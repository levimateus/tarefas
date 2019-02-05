package com.tasks.model.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.xml.bind.DatatypeConverter;

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

	public List<User> authenticate(String login, String password) throws NoSuchAlgorithmException {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tasks");
		EntityManager manager = factory.createEntityManager();
		
		password = this.encrypt(password);
		
		Query query = manager.createQuery("select user "
							+ "from User as user "
							+ "where user.login = :login and password = :password");
		
		query.setParameter("login", login);
		query.setParameter("password", password);
		
		List<User> users = query.getResultList();
		
		manager.close();
		factory.close();
		
		return users;
	}
	
	public String encrypt(String text) throws NoSuchAlgorithmException {
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		messageDigest.update(text.getBytes());
		byte[] digest = messageDigest.digest();
		String hash = DatatypeConverter.printHexBinary(digest).toLowerCase();
		
		return hash;
	}
}
