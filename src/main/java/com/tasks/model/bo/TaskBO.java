package com.tasks.model.bo;

import java.util.Calendar;
import java.util.List;

import com.tasks.model.bean.Task;
import com.tasks.model.bean.User;
import com.tasks.model.dao.TaskDAO;

public class TaskBO {
	
	public List<Task> getListByUser(User user){
		TaskDAO dao = new TaskDAO();
		return dao.getListByUser(user);
	}
	
	public boolean isLate(Task task) {
		Calendar taskDate = task.getTaskDate();
		
		if (taskDate.compareTo(Calendar.getInstance()) < 0) {
			return true;
		} else {
			return false;
		}
	}
}
