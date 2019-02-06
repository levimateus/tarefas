package com.tasks.web.servlet;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tasks.model.bean.User;
import com.tasks.model.dao.UserDAO;

public class Login extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		boolean isLogged = session != null && session.getAttribute("user") != null;
		
		if(isLogged) {
			response.sendRedirect(request.getContextPath() + "/");
		} else {
			request.getRequestDispatcher("/faces/login.jsp").include(request, response);			
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserDAO dao = new UserDAO();
		
		try {
			List<User> users;
			users = dao.authenticate(email, password);
			
			if(users.size() > 0) {
				HttpSession session = request.getSession();
				session.setAttribute("user", users.get(0));
				
				response.sendRedirect(request.getContextPath() + "/");
			} else {
				response.sendRedirect(request.getContextPath() + "/login.jsp?error=true");
			}
			
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
}
