package com.tasks.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tasks.model.bean.User;
import com.tasks.model.dao.UserDAO;

public class SignUp extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		request.getRequestDispatcher("/faces/sign-up.jsp").include(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		
		User user = new User();
		user.setName(request.getParameter("name"));
		user.setLogin(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		
		UserDAO dao = new UserDAO();
		user = dao.save(user);
		
		System.out.println("Inseriu o usuário " + user.getId());
	}
}
