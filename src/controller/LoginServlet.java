package controller;

import java.io.IOException;

import model.Owner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OwnerDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher;
		HttpSession session = request.getSession();
		
		Owner owner = (Owner) session.getAttribute("owner");
		
		if(owner != null){
			requestDispatcher = request.getRequestDispatcher("home.jsp");
		} 
		else {
			requestDispatcher = request.getRequestDispatcher("login.jsp");
		}
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OwnerDAO ownerDao = new OwnerDAO();
		Owner owner = ownerDao.searchOwnerByCode(Long.parseLong(request.getParameter("code"))); // mudar !!!!!!!!!!!!!!!!!!!!!
		
		RequestDispatcher requestDispatcher;
		
		if (owner != null){
			HttpSession session = request.getSession(true);
			session.setAttribute("owner", owner);
			
			requestDispatcher = request.getRequestDispatcher("home.jsp");
		}
		else{
			requestDispatcher = request.getRequestDispatcher("login.jsp");
		}
		
		requestDispatcher.forward(request, response);
	}

}
