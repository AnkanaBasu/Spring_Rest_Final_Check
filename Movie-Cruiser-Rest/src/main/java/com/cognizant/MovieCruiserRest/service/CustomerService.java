package com.cognizant.MovieCruiserRest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.MovieCruiserRest.model.Customer;
import com.cognizant.MovieCruiserRest.model.Movie;
import com.cognizant.MovieCruiserRest.repository.CustomerRepository;
import com.cognizant.MovieCruiserRest.repository.MovieRepository;

@Service

public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private MovieRepository movieRepository;
	@Transactional
	public List<Movie> viewAll(){
		return movieRepository.findAll();
	}
	@Transactional
	public List<Movie> viewActive(){
		return movieRepository.FindActiveList();
	}
	@Transactional
	public String addToFavourites(long customerId, long movieId) {
		Customer c=customerRepository.getOne(customerId);
		if(c!=null) {
			Movie m=movieRepository.getOne(movieId);
			if(m!=null) {
				List<Movie> favourites=c.getFavourites();
				favourites.add(m);
				c.setFavourites(favourites);
				customerRepository.save(c);
				return "SUCCESSFULL";
			}
			else {
				return "Movie Doesnt exist";
			}
		}
		else {
			return "Customer doesnt exist";
		}
	}
	@Transactional
	public String removeFromFavourites(long customerId, long movieId) {
		Customer c=customerRepository.getOne(customerId);
		if(c!=null) {
			Movie m=movieRepository.getOne(movieId);
			if(m!=null) {
				List<Movie> favourites=c.getFavourites();
				favourites.remove(m);
				c.setFavourites(favourites);
				customerRepository.save(c);
				return "SUCCESSFULL";
			}
			else {
				return "Movie Doesnt exist";
			}
		}
		else {
			return "Customer doesnt exist";
		}
	}
	@Transactional
	public List<Movie> showFavourites(long customerId){
		Customer c=customerRepository.getOne(customerId);
		if(c!=null) {
				List<Movie> favourites=c.getFavourites();
				return favourites;
		}
		else {
			return null;
		}
	}
}
