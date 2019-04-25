package com.bootPr.springBootRestfulServices.beans;

import java.time.LocalDate;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class User {

	public User(Long id, String userName, LocalDate dob) {
		super();
		this.id = id;
		this.userName = userName;
		this.dob = dob;
	}
	private Long id;
	
	@Size(min=2,message="Size must be at least 2 chars")
	private String userName;
	
	@Past
	private LocalDate dob;
	
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", userName=" + userName + "]";
	}
	
}
