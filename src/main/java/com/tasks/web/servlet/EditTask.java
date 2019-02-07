package com.tasks.web.servlet;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tasks.model.bean.Task;
import com.tasks.model.dao.TaskDAO;

public class EditTask extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String taskDateString = request.getParameter("task_date");
		String idTaskString = request.getParameter("id_task");
		int idTask;
		
		try {
			if(idTaskString.equals("")) {
				idTask = Integer.parseInt(idTaskString);
			} else {
				idTask = -1;
			}
		} catch (NumberFormatException e) {
			idTask = -1;
		}
		
		System.out.println("Tarefa: " + idTask);
		
		try {
			TaskDAO dao = new TaskDAO();
			Task task = new Task();
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date date;
			date = dateFormat.parse(taskDateString);
			Calendar taskDate = Calendar.getInstance();
			taskDate.setTime(date);
			
			task.setId(idTask == -1 ? null : idTask);
			task.setTitle(title);
			task.setDescription(description);
			task.setTaskDate(taskDate);
			
			dao.save(task);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
