package com.revature.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="album")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Album {
	
	@Id
	@Column(name="album_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String albumName;
	private String releaseDate;
	private double price;

// has list of tracks	
	@ManyToMany
	@JoinTable(name="album_track",
	joinColumns = @JoinColumn(name="album_id"),
	inverseJoinColumns = @JoinColumn(name="track_id"))
	private Set<Track> trackList;

	public Album(String albumName, String releaseDate, double price, Set<Track> trackList) {
		super();
		this.albumName = albumName;
		this.releaseDate = releaseDate;
		this.price = price;
		this.trackList = trackList;
	}
	
	// setTrackList(Track) exisits
	
	
	
}
