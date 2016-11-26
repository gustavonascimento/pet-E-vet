package web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns = "/*")
public class FilerURI implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req =  (HttpServletRequest) request;
		String uri = req.getRequestURI();
		Cookie[] cookies = req.getCookies();
		String owner = "<deslogado>";
		
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals("owner.deslogado")) {
				owner = cookie.getValue();
			}
		}
		
		System.out.println("Usuario " + owner + " acessoando a URI: " + uri);
		chain.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}


	
}
