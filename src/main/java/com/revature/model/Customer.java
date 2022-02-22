package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="customer")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Customer {
	
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	@Email // what happens if we send an invalid email?
	private String email;
	private String address;
	private String state;
	private String country;
	private String zipcode;
	private String phoneNumber;
	
	// foreign key for sales rep
	private int salesRepId;
	
	// constructor without id
	public Customer(String firstName, String lastName, @Email String email, String address, String state,
			String country, String zipcode, String phoneNumber, int salesRepId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.state = state;
		this.country = country;
		this.zipcode = zipcode;
		this.phoneNumber = phoneNumber;
		this.salesRepId = salesRepId;
	}
	
	
	
}
