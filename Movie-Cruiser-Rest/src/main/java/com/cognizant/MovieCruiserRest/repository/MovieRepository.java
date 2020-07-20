package com.cognizant.MovieCruiserRest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.MovieCruiserRest.model.Movie;
@Repository
public interface MovieRepository  extends JpaRepository<Movie,Long>{

	@Query("SELECT m FROM movie m WHERE m.active=true AND m.dateOfLaunch< ?1")
	public List<Movie> FindActiveList();
}
