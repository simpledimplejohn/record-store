package com.revature.data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {
	// included
	// .findAll()
	// .add(Object)
	// .getById(id)
	// .remove(id)
	
	Optional<Album> findByAlbumName(String albumName);
	
	// addTrackToTrackList
	
	
	
	
	
}
