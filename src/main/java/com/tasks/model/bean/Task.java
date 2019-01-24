package com.tasks.model.bean;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Task implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private User user;
	
	private String title;
	
	private String description;
	
	@Temporal(TemporalType.DATE)
	private Calendar creationDate;
	
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
	
	public String gettitle() {
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
