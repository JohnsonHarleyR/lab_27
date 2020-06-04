package co.grandcircus.lab27_createAPI.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.lab27_createAPI.entity.Movie;

public interface MovieDao extends JpaRepository<Movie, Long> {
	
	//idk if I'm doing this right
	
	//Get list of movies
	List<Movie> findAll();
	
	//Get movies by keyword
	List<Movie> findMoviesByKeyword(String Keyword);
	
	//When keyword is null
	List<Movie> findByKeyword();
	
	//Get movies by category
	List<Movie> findMoviesByCategory(String category);
	
	//When category is null?
	List<Movie> findByCategory();
	
	//Get a random movie
	Movie findRandom();
	
	//Get random movie from category
	Movie findRandomMovieByCategory(String category);
	
	//When category is empty?
	Movie findRandomByCategory();
	
	//Get list of random movies - by quantity
	List<Movie> findRandomMoviesByQuantity(int quantity);
	
	//When quantity is null?
	List<Movie> findRandomByQuantity();
	
	//Get a list of movie categories
	List<String> findMovieCategories();
	
}
