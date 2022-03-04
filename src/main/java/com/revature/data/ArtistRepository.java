package com.revature.data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Artist;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer>{
	
	Optional<Artist> findByLastName(String lastName);
	
}
