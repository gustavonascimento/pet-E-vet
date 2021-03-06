package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GenericDAO;
import dao.OwnerDAO;
import model.Owner;
import util.Cpf;
import util.Email;
import util.Telephone;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/OwnerServlet")
public class OwnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "WEB-INF/jsp/owner.jsp";
    private static String LIST_OWNER = "WEB-INF/jsp/listOwner.jsp";
    private GenericDAO<Owner> dao;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OwnerServlet() {
        super();
        dao = new OwnerDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("delete")){
			Long code = Long.parseLong(request.getParameter("code"));
			dao.delete(code);
			forward = LIST_OWNER;
			request.setAttribute("ownersList", dao.findAll());
		}else if(action.equalsIgnoreCase("edit")){
			forward = INSERT_OR_EDIT;
			Long code = Long.parseLong(request.getParameter("code"));
			Owner owner = dao.find(code);
			request.setAttribute("owner", owner);
		} else if(action.equalsIgnoreCase("listOwner")){
			forward = LIST_OWNER;
			request.setAttribute("ownersList", dao.findAll());
		} else {
			forward = INSERT_OR_EDIT;
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Owner owner = new Owner();
		
		owner.setName(request.getParameter("name"));
		owner.setCpf(new Cpf(request.getParameter("cpf")));
		owner.setEmail(new Email(request.getParameter("email")));
		owner.setTelephone(new Telephone(request.getParameter("telephone")));
		owner.setPassword(request.getParameter("password"));
		
		String code = request.getParameter("code");
		if (code == null || code.isEmpty()){
			dao.add(owner);
		} else {
			owner.setCode(Long.parseLong(code));
			dao.update(owner);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(LIST_OWNER);
		request.setAttribute("ownersList", dao.findAll());
		dispatcher.forward(request, response);
	}

}
