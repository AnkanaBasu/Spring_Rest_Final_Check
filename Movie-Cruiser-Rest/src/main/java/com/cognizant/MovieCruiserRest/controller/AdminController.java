package com.cognizant.MovieCruiserRest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.MovieCruiserRest.model.Movie;
import com.cognizant.MovieCruiserRest.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	@GetMapping()
	public List<Movie> getAll(){
		return adminService.getAll();
	}
	@PutMapping("/update/{id}")
	public String edit( @RequestBody Movie movie) {
		return adminService.update(movie);
	}
}
