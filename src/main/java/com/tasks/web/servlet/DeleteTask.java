package com.tasks.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tasks.model.bean.Task;
import com.tasks.model.dao.TaskDAO;

public class DeleteTask extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));
		
		Task task = new Task();
		task.setId(id);
		
		TaskDAO dao = new TaskDAO();
		dao.delete(id);
		
		response.sendRedirect(request.getHeader("referer"));
	}
}
