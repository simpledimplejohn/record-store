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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id") //for network issues

public class Customer {
	
	@Id
	@Column(name="customer_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Length(min=2)
	private String firstName;
	private String lastName;
	@NotBlank
	@Pattern(regexp="[a-zA-Z][a-zA-Z0-9]*")
	private String userName;
	@NotBlank
	private String password;
	@Email // what happens if we send an invalid email?
	private String email;
	private String address;
	// List of albums 
	
	@ManyToMany
	@JoinTable(name= "customer_album",
	joinColumns = @JoinColumn(name="customer_id"),
	inverseJoinColumns = @JoinColumn(name= "album_id"))
	// ToDo Json View profile???
	private Set<Album> albums;

	
	// constructor without id for hibernate
	public Customer(@Length(min = 2) String firstName, String lastName,
			@NotBlank @Pattern(regexp = "[a-zA-Z][a-zA-Z0-9]*") String userName, @NotBlank String password,
			@Email String email, String address, Set<Album> albums) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.address = address;
		this.albums = albums;
	}
	

	
	

	
	
	
	
}
