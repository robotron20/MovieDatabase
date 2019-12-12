package com.planview.model;

import java.util.ArrayList;

public class Movie {
	
	private String name;
	private Integer year;
	
	private ArrayList<Actor> actorList = new ArrayList<>();
	
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

	public ArrayList<Actor> getActorList() {
		return actorList;
	}
	
}
