package com.revature.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Album;
import com.revature.model.Track;
import com.revature.service.AlbumService;
import com.revature.service.TrackService;

@RestController
@RequestMapping("/album")
public class AlbumController {
	
	private static final int Track = 0;

	@Autowired
	AlbumService albumServ;
	
	@Autowired
	TrackService trackServ;
	
	@GetMapping
	public Set<Album> getAll() {
		return albumServ.findAll();
	}
	
	@GetMapping("/find/{albumName}")
	public Album findByAlbumName(@PathVariable("albumName") String albumName) {
		return albumServ.findByAlbumName(albumName);
	}
	
	@GetMapping("/{id}")
	public Album findById(@PathVariable("id") int id) {
		return albumServ.findById(id);
	}
	
	@PostMapping("/add")
	public Album add(@RequestBody Album a) {
		return albumServ.add(a);
	}
	
	// add track to exisiting alubm is a Put request using save
	@PutMapping("/{id}/addtrack")
	public Album addTrackToAlbum(@RequestBody Track t, @PathVariable("id") int id) {
		// add the track to the track object
		
		trackServ.add(t);
		Set<Track> trackList = new HashSet<>();
		
		trackList.add(t);
		// add the track to the Album list
		Album a = albumServ.findById(id);
		a.setTrackList(trackList);
		
		
		
		return albumServ.add(a);
	}
	
	
	
}
