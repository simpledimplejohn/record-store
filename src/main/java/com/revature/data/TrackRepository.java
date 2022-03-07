package com.revature.data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Track;

@Repository
public interface TrackRepository extends JpaRepository<Track, Integer>{
	Optional<Track> findByTitle(String title);
	
}
