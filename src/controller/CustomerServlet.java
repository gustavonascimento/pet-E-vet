package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDAO;
import util.Address;
import util.Cpf;
import util.Email;
import util.Telephone;
import model.Customer;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/customer.jsp";
    private static String LIST_USER = "/listCustomer.jsp";
    private CustomerDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        dao = new CustomerDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("edit")){
			forward = INSERT_OR_EDIT;
			Long code = Long.parseLong(request.getParameter("code"));
			Customer customer = dao.searchCustomerByCode(code);
			request.setAttribute("customer", customer);
		} else if(action.equalsIgnoreCase("listCustomer")){
			forward = LIST_USER;
			request.setAttribute("customersList", dao.getAllCustomers());
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
		Customer customer = new Customer();
		
		customer.setName(request.getParameter("name"));
		customer.setCpf(new Cpf(request.getParameter("cpf")));
		customer.setEmail(new Email(request.getParameter("email")));
		customer.setTelephone(new Telephone(request.getParameter("telephone")));
		customer.setDate_of_birth(request.getParameter("date_of_birth"));
		customer.setAddress(new Address(request.getParameter("address"),
															  	request.getParameter("neighborhood"),
																request.getParameter("city"),
																request.getParameter("cep")));
		
		String code = request.getParameter("code");
		if (code == null || code.isEmpty()){
			dao.addCustumer(customer);
		} else {
			customer.setCode(Long.parseLong(code));
			dao.updateCustomer(customer);
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(LIST_USER);
		request.setAttribute("customersList", dao.getAllCustomers());
		dispatcher.forward(request, response);
	}

}
