package com.tasks.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tasks.model.bean.Task;
import com.tasks.model.dao.TaskDAO;

public class CloseTask extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));

		TaskDAO dao = new TaskDAO();		
		Task task = dao.getTask(id);
		
		String open = request.getParameter("open") != null ? request.getParameter("open") : "0";
		
		if (open.equals("1")) {
			task.setFinished(false);
		} else {
			task.setFinished(true);
		}
		
		dao.update(task);
		
		request.getRequestDispatcher("/").include(request, response);
	}
}
