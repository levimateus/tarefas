package com.tasks.model.bean;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Task implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private User user;
	
	@NotNull
	private String title;
	
	@Lob
	private String description;
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Calendar creationDate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	private Calendar alterationDate;
	
	@Temporal(TemporalType.DATE)
	private Calendar taskDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Calendar getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Calendar creationDate) {
		this.creationDate = creationDate;
	}

	public Calendar getAlterationDate() {
		return alterationDate;
	}

	public void setAlterationDate(Calendar alterationDate) {
		this.alterationDate = alterationDate;
	}

	public Calendar getTaskDate() {
		return taskDate;
	}

	public void setTaskDate(Calendar taskDate) {
		this.taskDate = taskDate;
	}
}
