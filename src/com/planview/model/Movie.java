package com.planview.model;

public class Movie {
	
	private String name;
	private Integer year;
	
	public Movie(String name, Integer year) {
		
		super();
		
		this.name = name;
		this.year = year;
		
	}
	
	public String getName() {
		return name;
	}

	public Integer getYear() {
		return year;
	}
	
}
