package co.grandcircus.lab27_createAPI;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import co.grandcircus.lab27_createAPI.dao.MovieDao;
import co.grandcircus.lab27_createAPI.entity.Movie;

//Note: All movie descriptions are taken from the IMDb website.

@RestController
public class ApiController {
	
	@Autowired
	private MovieDao repo;
	
	
	//I don't fully understand what I'm doing yet, but I hope it's right lol.
	//I did everything on the homework, I have no idea how to test it though.
	
	//I hope to learn this better. I bet I'm not the only confused one.
	
	
	//Aggregate root (What does this even mean lol?)
	
	
	//Get a list of all movies
	@GetMapping("/movies")
	List<Movie> all() {
		return repo.findAll();
	}
	
	//Save new movie
	@PostMapping ("/movies")
	Movie newMovie(@RequestBody Movie movie) {
		return repo.save(movie);
	}
	
	//find movies by keyword in a title
	@GetMapping("/movies/title")
	List<Movie> byTitle(@RequestParam(value = "title", required = false) String keyword) {
		
		if (keyword == null || keyword.isEmpty()) {
			return repo.findByKeyword();
		} else {
			return repo.findMoviesByKeyword(keyword);
		}
		
	}
	
	//doing right?
	//Get movies in a specified category
	@GetMapping("/movies/{category}") 
	List<Movie> byCategory(@PathVariable String category) {
		
		if (category == null || category.isEmpty()) {
			return repo.findByCategory();
		} else {
			return repo.findMoviesByCategory(category);
		}
	}
	
	//Single item
	//Get movie by id
	@GetMapping("/movies/{id}")
	Movie byId(@PathVariable Long id) {
		return repo.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						"No such Movie."));
		//Can I do it this way for some of the others, or just findById?
	}
	
	//Get random movie
	@GetMapping("/movies/random")
	Movie random() {
		List<Movie> movies = repo.findAll();
		int random = (int)(Math.random() * movies.size()); //shouldn't need +1 in this instance
		
		return movies.get(random);
	}
	
	//Get random movie in a category
	@GetMapping("/movies/random/{category}")
	Movie randomByCategory(@PathVariable String category) {
		if (category == null || category.isEmpty()) {
			return repo.findRandomByCategory();
		} else {
			return repo.findRandomMovieByCategory(category);
		}
	}
	
	//Get random movies by quantity
	//Is it necessary to do it like this for all of them? Just checking
	@GetMapping("/movies/random/{quantity}")
	List<Movie> randomMovies(@PathVariable int quantity) {
		if (quantity == 0) { //it says quantity cannot equal null so idk
			return repo.findRandomByQuantity();
		} else {
			return repo.findRandomMoviesByQuantity(quantity);
		}
	}
	
	//All categories
	@GetMapping("/categories")
	List<String> allCategories() {
		return repo.findMovieCategories();
	}

}
