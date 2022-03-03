package com.revature.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Album;
import com.revature.service.AlbumService;

@RestController
@RequestMapping("/album")
public class AlbumController {
	
	@Autowired
	AlbumService albumServ;
	
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
	
}
