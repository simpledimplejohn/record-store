package com.revature.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.data.ArtistRepository;
import com.revature.exception.ArtistNotFoundException;
import com.revature.model.Artist;

@Service
public class ArtistService {

	ArtistRepository artistRepo;
	
	public List<Artist> findAll() {
		return artistRepo.findAll();
	}
	
	public Artist add(Artist a) {
		return artistRepo.save(a);
	}
	
	public Artist findByArtistLastName(String lastName) {
		return artistRepo.findByLastName(lastName).orElseThrow(() -> new ArtistNotFoundException("No artist found with this last name " + lastName));
	}
	
	public Artist findById(int id) {
		return artistRepo.findById(id).orElseThrow(() -> new ArtistNotFoundException("No artist found with id " + id));
	}
	
}
