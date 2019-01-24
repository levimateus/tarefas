package com.tasks.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tasks.model.bean.User;

public class UserDAO {

	public User save(User user) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tasks");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(user);
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
		
		return user;
	}
	
	public User find(User user) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tasks");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.find(User.class, user);
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
		
		return user;
	}
	
	public User update(User user) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tasks");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.merge(user);
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
		
		return user;
	}
	
	public User delete(User user) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tasks");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.remove(user);
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
		
		return user;
	}
}
