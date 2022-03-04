package com.revature.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.data.AlbumRepository;
import com.revature.exception.AlbumNotFoundException;
import com.revature.model.Album;

@Service
public class AlbumService {
	
	@Autowired
	AlbumRepository albumRepo;
	
	public Set<Album> findAll() {
		return albumRepo.findAll().stream().collect(Collectors.toSet());
	}
	
	public Album add(Album a) {
		return albumRepo.save(a);
	}
	
	public Album findByAlbumName(String albumName) {
		return albumRepo.findByAlbumName(albumName).orElseThrow(() -> new AlbumNotFoundException("No Album found with this name" + albumName));
	}
	
	public Album findById(int id) {
		return albumRepo.findById(id).orElseThrow(() -> new AlbumNotFoundException("No Album Found with this id " + id));
	}
	
}
