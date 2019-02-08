package com.tasks.web.servlet;

import java.util.Calendar;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tasks.model.bean.Task;
import com.tasks.model.bean.User;
import com.tasks.model.dao.TaskDAO;

public class CreateTask extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");
		
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		
		try {
			TaskDAO dao = new TaskDAO();
			Task task = new Task();
			Calendar taskDate = Calendar.getInstance();
			
			task.setUser(user);
			task.setTitle(title);
			task.setDescription(description);
			task.setTaskDate(taskDate);
			
			dao.save(task);
			
			response.sendRedirect("today.jsp");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
