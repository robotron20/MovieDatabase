package com.planview.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.planview.model.Actor;
import com.planview.model.Movie;

public class MovieDatabase {
	
	private HashMap<String, Actor> actorList = new HashMap<>();
	private HashMap<String, Movie> movieList = new HashMap<>();
	
	private HashMap<Actor, ArrayList<Movie>> actorMovieList = new HashMap<>();
	private HashMap<Movie, ArrayList<Actor>> movieActorList = new HashMap<>();
	
	public static void main(String[] args) {
		
		MovieDatabase movieDatabase = new MovieDatabase();
		movieDatabase.test();
		
	}
	
	public void test() {
		
		try {
			
			Actor actor1 = this.addActor("Harrison Ford", new SimpleDateFormat("MMddyyyy").parse("07131942"));
			Actor actor2 = this.addActor("Sean Connery", new SimpleDateFormat("MMddyyyy").parse("08251930"));
			Actor actor3 = this.addActor("River Phoenix", new SimpleDateFormat("MMddyyyy").parse("08231970"));
			Movie movie1 = this.addMovie("Indiana Jones and the Last Crusade", 1989);
			Movie movie2 = this.addMovie("Patriot Games", 1992);
			Movie movie3 = this.addMovie("The Fugitive", 1993);
			Movie movie4 = this.addMovie("Time Bandits", 1981);
			Movie movie5 = this.addMovie("HighLander", 1986);
			Movie movie6 = this.addMovie("The Mosquito Coast", 1986);
			
			attach(actor1, movie1);
			attach(actor2, movie1);
			attach(actor1, movie2);
			attach(actor1, movie3);
			attach(actor2, movie4);
			attach(actor2, movie5);
			attach(actor3, movie1);
			attach(actor1, movie6);
			attach(actor3, movie6);
			
			String actorName = "Harrison Ford";
			
			ArrayList<Movie> movieList1 = findAllMovies(actorName);
			
			System.out.println(actorName + " acted in the following movies...");
			
			for (Movie movie : movieList1) {
				System.out.println(movie.getName());
			}
			
			System.out.println("");
			
			ArrayList<Actor> coactorList1 = findAllCoactors(actorName);
			
			System.out.println(actorName + " acted with the following coactors...");
			
			for (Actor actor : coactorList1) {
				System.out.println(actor.getName());
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Creates our references between actors and movies
	 * 
	 * @param actor
	 * @param movie
	 */
	public void attach(Actor actor, Movie movie) {
		
		ArrayList<Movie> movieList = actorMovieList.get(actor);
		
		if (movieList == null) {
			
			movieList = new ArrayList<>();
			
			actorMovieList.put(actor, movieList);
			
		}
		
		movieList.add(movie);
		
		ArrayList<Actor> actorList = movieActorList.get(movie);
		
		if (actorList == null) {
			
			actorList = new ArrayList<>();
			
			movieActorList.put(movie, actorList);
			
		}
		
		actorList.add(actor);
		
	}
	
	/**
	 * Creates actor and adds it to our actor list 
	 * 
	 * @param name
	 * @param birthDate
	 * @return actor you created
	 */
	public Actor addActor(String name, Date birthDate) {
		
		Actor actor = new Actor(name, birthDate);
		actorList.put(name, actor);
		
		return actor;
		
	}
	
	/**
	 * Creates movie and adds it to our movie list
	 * 
	 * @param name
	 * @param year
	 * @return movie you created
	 */
	public Movie addMovie(String name, Integer year) {
		
		Movie movie = new Movie(name, year);
		movieList.put(name, movie);
		
		return movie;
		
		
	}
	
	/**
	 * Finds all movies an actor acted in
	 * 
	 * @param actorName
	 * @return list of movies
	 */
	public ArrayList<Movie> findAllMovies(String actorName) {
		
		Actor actor = actorList.get(actorName);
		
		if (actor != null) {
		
			ArrayList<Movie> movieList = actorMovieList.get(actor);
			
			return movieList;
			
		}
		
		return null;
		
	}
	
	/**
	 * Finds all coactor which an actor worked with
	 * 
	 * @param actorName
	 * @return list of coactors
	 */
	public ArrayList<Actor> findAllCoactors(String actorName) {
		
		ArrayList<Actor> resultList = new ArrayList<>();
		
		Actor actor = actorList.get(actorName);
		
		ArrayList<Movie> foundMovieList = this.findAllMovies(actorName);
		
		if (foundMovieList != null) {
		
			for (Movie movie : foundMovieList) {
				
				ArrayList<Actor> coactorList = movieActorList.get(movie);
				
				if (coactorList != null) {
				
					for (Actor coactor : coactorList) {
						
						if ((coactor != actor) && !resultList.contains(coactor)) {
							resultList.add(coactor);
						}
						
					}
					
				}
				
			}
			
		}
		
		return resultList;
		
	}
	
}
