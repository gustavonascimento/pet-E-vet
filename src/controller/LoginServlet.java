package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import model.Owner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
    private static final String HOME_VIEW = "WEB-INF/jsp/home.jsp";
    private static final String LOGIN = "WEB-INF/jsp/login.jsp";
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
			requestDispatcher = request.getRequestDispatcher(HOME_VIEW);
		} 
		else {
			requestDispatcher = request.getRequestDispatcher(LOGIN);
		}
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OwnerDAO ownerDao = new OwnerDAO();
		Owner owner = ownerDao.searchOwner(request.getParameter("email"), request.getParameter("password"));
		
		String email = request.getParameter("email");
	    String password = request.getParameter("password");
	    Map<String, String> messages = new HashMap<String, String>();
		RequestDispatcher requestDispatcher;
		
		if (email == null || email.isEmpty()) {
            messages.put("username", "Please enter username");
        }

        if (password == null || password.isEmpty()) {
            messages.put("password", "Please enter password");
        }
		
		
		if (owner != null){
			HttpSession session = request.getSession(true);
			session.setAttribute("owner", owner);
			Cookie cookie = new Cookie("owner.signup", email);
			response.addCookie(cookie);
			
			requestDispatcher = request.getRequestDispatcher(HOME_VIEW);
			
		}
		else{
			requestDispatcher = request.getRequestDispatcher(LOGIN);
		}
		
		requestDispatcher.forward(request, response);
	}

}
