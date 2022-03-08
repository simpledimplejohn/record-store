package com.revature.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.data.AlbumRepository;
import com.revature.data.ArtistRepository;
import com.revature.data.TrackRepository;
import com.revature.exception.AlbumNotFoundException;
import com.revature.model.Album;

@Service
public class AlbumService {

	@Autowired
	AlbumRepository albumRepo;

	@Autowired
	TrackRepository trackRepo;

	@Autowired
	ArtistRepository artistRepo;

	public Set<Album> findAll() {
		return albumRepo.findAll().stream().collect(Collectors.toSet());
	}
	// adds an album, a track list, and an artist list
	
	public Album add(Album a) {

		if (a.getTrackList() != null) {
			a.getTrackList().forEach((t) -> {
				if (t.getArtistList() != null) {
					t.getArtistList().forEach((ar) -> {
						artistRepo.save(ar);
					});
				}
				trackRepo.save(t);
			});
		}

		return albumRepo.save(a);
	}

	public Album findByAlbumName(String albumName) {
		return albumRepo.findByAlbumName(albumName)
				.orElseThrow(() -> new AlbumNotFoundException("No Album found with this name" + albumName));
	}

	public Album findById(int id) {
		return albumRepo.findById(id)
				.orElseThrow(() -> new AlbumNotFoundException("No Album Found with this id " + id));
	}

	// Add a track to the album here

//	public Track add(Track t) {
//		return 
//	}

}
