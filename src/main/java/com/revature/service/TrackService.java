package com.revature.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.data.TrackRepository;
import com.revature.exception.TrackNotFoundException;
import com.revature.model.Track;

@Service
public class TrackService {
	
	TrackRepository trackRepo;
	
	public List<Track> findAll() {
		return trackRepo.findAll();
	}
	
	public Track findByTitle(String title) {
		return trackRepo.findByTitle(title).orElseThrow(() -> new TrackNotFoundException("Track not found with this title " + title));
	}
	
	public Track findById(int id) {
		return trackRepo.findById(id).orElseThrow(() -> new TrackNotFoundException("Track not found with id " + id));
	}
	
	public Track add(Track t) {
		return trackRepo.save(t);
	}
	
	//TODO add delete
}
