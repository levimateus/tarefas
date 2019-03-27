package com.tasks.model.dao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tasks.model.bean.Task;
import com.tasks.model.bean.User;

public class TaskDAO {

	public Task save(Task task) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tasks");
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();
		manager.persist(task);
		manager.getTransaction().commit();

		manager.close();
		factory.close();

		return task;
	}

	public Task getTask(Task task) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tasks");
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();
		manager.find(Task.class, task);
		manager.getTransaction().commit();

		manager.close();
		factory.close();

		return task;
	}

	public List<Task> getList() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tasks");
		EntityManager manager = factory.createEntityManager();

		List<Task> tasks = manager.createQuery("select t from Task as t").getResultList();

		return tasks;
	}

	public List<Task> getListByUser(User user){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tasks");
		EntityManager manager = factory.createEntityManager();
		
		Query query = manager.createQuery("select t from Task as t "
				+ "where t.user = :user "
				+ "order by t.taskDate asc");
		
		query.setParameter("user", user);
		
		List<Task> list = query.getResultList();
		
		return list;
	}
	
	public List<Task> getListToday(User user){	
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tasks");
		EntityManager manager = factory.createEntityManager();
		
		Query query = manager.createQuery("select t from Task as t "
				+ "where t.user = :user "
				+ "AND year(t.taskDate) = year(current_date())"
				+ "AND month(t.taskDate) = month(current_date())"
				+ "AND day(t.taskDate) = day(current_date())"
				+ "order by t.title asc");
		
		query.setParameter("user", user);
		
		List<Task> list = query.getResultList();
		
		return list;
	}

	public Task update(Task task) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tasks");
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();
		manager.merge(task);
		manager.getTransaction().commit();

		manager.close();
		factory.close();

		return task;
	}

	public Task delete(Integer id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tasks");
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();
		
		Task task = manager.find(Task.class, id);
		manager.remove(task);
		manager.getTransaction().commit();

		manager.close();
		factory.close();

		return task;
	}
}
