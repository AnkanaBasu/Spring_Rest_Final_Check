package com.cognizant.MovieCruiserRest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.MovieCruiserRest.model.Movie;
import com.cognizant.MovieCruiserRest.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@GetMapping("/allmovies")
	public List<Movie> getAllMovies(){
		return customerService.viewAll();
	}
	@GetMapping()
	public List<Movie> getAllActiveMovies(){
		return customerService.viewActive();
	}
	@GetMapping("/addtofavourites/{customerid}/{movieid}")
	public String addToFavourites(@PathVariable(name = "customerid") long customerId,@PathVariable(name = "movieid") long movieId) {
		return customerService.addToFavourites(customerId,movieId);
	}
	@DeleteMapping("/removefromfavourites/{customerid}/{movieid}")
	public String deleteFromFavourites(@PathVariable(name = "customerid") long customerId,@PathVariable(name = "movieid") long movieId) {
		return customerService.removeFromFavourites(customerId,movieId);
	}
	@GetMapping("/showfavourites/{id}")
	public List<Movie> showFavourites(@PathVariable(name="id") long customerId){
		return customerService.showFavourites(customerId);
	}
	
}
