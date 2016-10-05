package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
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
    private static String INSERT_OR_EDIT = "/employee.jsp";
    private static String LIST_USER = "/listEmployee.jsp";
    private EmployeeDAO employeeDao;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        employeeDao = new EmployeeDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("delete")){
			Long code = Long.parseLong(request.getParameter("code"));
			employeeDao.deleteEmployee(code);
			forward = LIST_USER;
			request.setAttribute("employeeList", employeeDao.getAllEmployees());
		}else if(action.equalsIgnoreCase("edit")){
			forward = INSERT_OR_EDIT;
			Long code = Long.parseLong(request.getParameter("code"));
			Employee employee = employeeDao.searchEmployeeByCode(code);
			request.setAttribute("employee", employee);
		} else if(action.equalsIgnoreCase("listEmployee")){
			forward = LIST_USER;
			request.setAttribute("employeesList", employeeDao.getAllEmployees());
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
		employee.setEmployeeRole(request.getParameter("employee_role"));
		
		String code = request.getParameter("code");
		if (code == null || code.isEmpty()){
			employeeDao.addEmployee(employee);
		} else {
			employee.setCode(Long.parseLong(code));
			employeeDao.updateEmployee(employee);
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(LIST_USER);
		request.setAttribute("employeesList", employeeDao.getAllEmployees());
		dispatcher.forward(request, response);
	}
}
