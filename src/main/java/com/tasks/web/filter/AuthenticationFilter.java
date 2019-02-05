package com.tasks.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthenticationFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String url = req.getRequestURI();
		url = url.substring(url.lastIndexOf("/"), url.length());
				
		HttpSession session = req.getSession(false);
		boolean isLogged = session != null && session.getAttribute("user") != null; 
		boolean isOpenPage = url.compareTo("/login.jsp") == 0 || url.compareTo("/sign-up.jsp") == 0; 
		
		if(isLogged || isOpenPage) {
			chain.doFilter(request, response);			
		} else {
			res.sendRedirect(req.getContextPath() + "/login.jsp");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
