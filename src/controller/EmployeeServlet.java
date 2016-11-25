package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import dao.GenericDAO;
import model.Employee;
import util.Cpf;
import util.Email;
import util.Telephone;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "WEB-INF/jsp/employee.jsp";
    private static String LIST_EMPLOYEE = "WEB-INF/jsp/listEmployee.jsp";
    private GenericDAO<Employee> dao;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        dao = new EmployeeDAO();
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
			forward = LIST_EMPLOYEE;
			request.setAttribute("employeeList", dao.findAll());
		}else if(action.equalsIgnoreCase("edit")){
			forward = INSERT_OR_EDIT;
			Long code = Long.parseLong(request.getParameter("code"));
			Employee employee = dao.find(code);
			request.setAttribute("employee", employee);
		} else if(action.equalsIgnoreCase("listEmployee")){
			forward = LIST_EMPLOYEE;
			request.setAttribute("employeesList", dao.findAll());
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
		Employee employee = new Employee();
		
		employee.setName(request.getParameter("name"));
		employee.setCpf(new Cpf(request.getParameter("cpf")));
		employee.setEmail(new Email(request.getParameter("email")));
		employee.setTelephone(new Telephone(request.getParameter("telephone")));
		employee.setRole(request.getParameter("role"));
		
		String code = request.getParameter("code");
		if (code == null || code.isEmpty()){
			dao.add(employee);
		} else {
			employee.setCode(Long.parseLong(code));
			dao.update(employee);
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(LIST_EMPLOYEE);
		request.setAttribute("employeesList", dao.findAll());
		dispatcher.forward(request, response);
	}
}
