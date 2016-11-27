package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LogoutServlet implements Task {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getSession().invalidate();
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} catch (ServletException | IOException servletException) {
			throw new RuntimeException("Falha ao deslogar!");
		}
		return "WEB-INF/login.jsp";
	}
}
