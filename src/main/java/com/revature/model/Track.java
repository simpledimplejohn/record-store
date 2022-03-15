package com.revature.model;

import java.util.List;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="track")
@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id") //for network issues

public class Track {
	
	@Id
	@Column(name="track_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String title;
	// TODO change duration to time value
	private String duration;
	
	@ManyToMany
	@JoinTable(name= "track_artist",
	joinColumns = @JoinColumn(name="track_id"),
	inverseJoinColumns = @JoinColumn(name="artist_id"))
	private List<Artist> artistList;

	public Track(String title, String duration, List<Artist> artistList) {
		super();
		this.title = title;
		this.duration = duration;
		this.artistList = artistList;
	}
	
	

}
