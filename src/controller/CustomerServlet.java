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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("name", request.getParameter("name"));
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
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
		customer.setTelephoneNumber(new Telephone(request.getParameter("telephone")));
		customer.setDateOfBirth(request.getParameter("date_of_birth"));
		customer.setAddress(new Address(request.getParameter("address"),
															  	request.getParameter("neighborhood"),
																request.getParameter("city"),
																request.getParameter("cep")));
		
		CustomerDAO dao = new CustomerDAO();
		dao.addCustumer(customer);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("");
		dispatcher.forward(request, response);
	}

}
