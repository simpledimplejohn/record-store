package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Track;
import com.revature.service.TrackService;

@RestController
@RequestMapping("/track")
public class TrackController {
	
	@Autowired
	TrackService trackServ;
	
	@GetMapping
	public List<Track> getAll() {
		return trackServ.findAll();
	}
	
	@GetMapping("/find/{title}")
	public Track getByTitle(@PathVariable("title") String title) {
		return trackServ.findByTitle(title);
	}
	
	@GetMapping("/{id}")
	public Track findById(@PathVariable("id") int id) {
		return trackServ.findById(id);
	}
	
	@PostMapping("/add")
	public Track add(Track t) {
		return trackServ.add(t);
	}
	
}
