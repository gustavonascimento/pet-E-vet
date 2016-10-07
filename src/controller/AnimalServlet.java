package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Animal;
import model.Customer;
import dao.AnimalDAO;
import dao.CustomerDAO;

/**
 * Servlet implementation class AnimalServlet
 */
@WebServlet("/AnimalServlet")
public class AnimalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private static String LIST_ANIMALS = "/listAnimal.jsp";
    private static String INSERT = "/animal.jsp";
    private AnimalDAO animalDao;
    private CustomerDAO customerDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnimalServlet() {
        super();
        animalDao = new AnimalDAO();
        customerDao = new CustomerDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");

			
		if(action.equalsIgnoreCase("deleteAnimal")){
			String name = request.getParameter("name");
			animalDao.deleteAnimal(name);
			forward = LIST_ANIMALS;
			Long code = Long.parseLong(request.getParameter("code"));
			request.setAttribute("animalsList", animalDao.listAnimalsForACustomer(code));
		}
		else if(action.equalsIgnoreCase("listAnimal")){
			forward = LIST_ANIMALS;
			Long code = Long.parseLong(request.getParameter("code"));
			Customer customer = customerDao.searchCustomerByCode(code);
			request.setAttribute("customer", customer);
			request.setAttribute("animalsList", animalDao.listAnimalsForACustomer(code));
			
		}else if (action.equalsIgnoreCase("insert")){
			forward = INSERT;
			Long code = Long.parseLong(request.getParameter("code"));
			Customer customer = customerDao.searchCustomerByCode(code);
			request.setAttribute("customer", customer);

		}else{
			forward = INSERT;
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
		dispatcher.forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Animal animal = new Animal();
		
		animal.setCode(Long.parseLong(request.getParameter("code")));
		animal.setName(request.getParameter("name"));
		animal.setBreed(request.getParameter("breed"));
		animal.setAge(Integer.parseInt(request.getParameter("age")));
		animal.setSex(request.getParameter("sex").charAt(0));
		
		animalDao.addAnimal(animal);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(LIST_ANIMALS);
		Long code = Long.parseLong(request.getParameter("code"));
		Customer customer = customerDao.searchCustomerByCode(code);
		request.setAttribute("customer", customer);
		request.setAttribute("animalsList", animalDao.listAnimalsForACustomer(code));
		dispatcher.forward(request, response);
	}

}
