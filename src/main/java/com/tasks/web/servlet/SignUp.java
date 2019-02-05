package com.tasks.web.servlet;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;

import com.tasks.model.bean.User;
import com.tasks.model.dao.UserDAO;

public class SignUp extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("/faces/sign-up.jsp").include(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		User user = new User();
		
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String login = request.getParameter("email");
		
		try {
			UserDAO dao = new UserDAO();
			
			password = dao.encrypt(password); 
			
			user.setName(name);
			user.setLogin(login);
			user.setPassword(password);
			
			user = dao.save(user);
			System.out.println("Inseriu o usuário " + user.getId());
			
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}		
	}
}
