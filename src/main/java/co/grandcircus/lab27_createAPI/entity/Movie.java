package co.grandcircus.lab27_createAPI.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private int year;
	private String category;
	private String description;
	private String rating;
	
	public Movie() {}
	
	
	public Movie(String title, int year, String category, String description, String rating) {
		
		super();
		
		this.title = title;
		this.year = year;
		this.category = category;
		this.description = description;
		this.rating = rating;
	
	}

	//@return GET id
	public Long getId() {
		return id;
	}
	
	//@param SET id
	public void setId(Long id) {
		this.id = id;
	}
	
	//@return GET title
	public String getTitle() {
		return title;
	}
	
	//@param SET title
	public void setTitle(String title) {
		this.title = title;
	}
	
	//@return GET year
	public int getYear() {
		return year;
	}
	
	//@param SET year
	public void setYear(int year) {
		this.year = year;
	}
	
	//@return GET category
	public String getCategory() {
		return category;
	}
	
	//@param SET category
	public void setCategory(String category) {
		this.category = category;
	}
	
	//@return GET description
	public String getDescription() {
		return description;
	}
	
	//@param SET description
	public void setDescription(String description) {
		this.description = description;
	}
	
	//@return GET rating
	public String getRating() {
		return rating;
	}
	
	//@param SET rating
	public void setRating(String rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", year=" + year + ", category=" + category + ", description="
				+ description + ", rating=" + rating + "]";
	}
	
	
	
}
