package com.tasks.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tasks.model.bean.Task;

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
	
	public Task find(Task task) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tasks");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.find(Task.class, task);
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
		
		return task;
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
	
	public Task delete(Task task) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tasks");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.remove(task);
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
		
		return task;
	}
}
