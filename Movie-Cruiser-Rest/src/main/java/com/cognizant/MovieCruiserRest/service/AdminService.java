package com.cognizant.MovieCruiserRest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.MovieCruiserRest.model.Movie;
import com.cognizant.MovieCruiserRest.repository.MovieRepository;

@Service
public class AdminService {

	@Autowired
	private MovieRepository movieRepository;
	@Transactional
	public List<Movie> getAll() {
		return movieRepository.findAll();
	}
	@Transactional
	public String update(Movie movie) {
		Movie m = movieRepository.getOne(movie.getId());
		if(m!=null) {
			movieRepository.save(movie);
			return "Successfully Updated the movie";
		}
		else {
		return "The movie with id "+movie.getId()+" is not found.";
		}
		}
}
