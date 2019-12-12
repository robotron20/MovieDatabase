package com.planview.model;

import java.util.ArrayList;
import java.util.Date;

public class Actor {
	
	private String name;
	private Date birthDate;
	
	private ArrayList<Movie> movieList = new ArrayList<>();
	
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

	public ArrayList<Movie> getMovieList() {
		return movieList;
	}
	
}
