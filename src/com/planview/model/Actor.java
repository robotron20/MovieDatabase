package com.planview.model;

import java.util.Date;

public class Actor {
	
	private String name;
	private Date birthDate;
	
	public Actor(String name, Date birthDate) {
		
		super();
		
		this.name = name;
		this.birthDate = birthDate;
		
	}
	
	public String getName() {
		return name;
	}

	public Date getBirthDate() {
		return birthDate;
	}
	
}
