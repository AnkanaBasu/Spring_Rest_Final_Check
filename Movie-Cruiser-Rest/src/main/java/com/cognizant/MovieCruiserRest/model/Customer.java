package com.cognizant.MovieCruiserRest.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import lombok.Data;

@Entity
@Table(name = "customer")
@Data
public class Customer {
	
	@Id
    private long id;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(
			name = "Favourites", 
	        joinColumns = { @JoinColumn(name = "user_id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "id") }
	)
	private List<Movie> favourites=new ArrayList<>();
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<Movie> getFavourites() {
		return favourites;
	}
	public void setFavourites(List<Movie> favourites) {
		this.favourites = favourites;
	}
	
}
