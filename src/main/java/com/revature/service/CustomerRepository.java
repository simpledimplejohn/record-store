package com.revature.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.revature.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	// Dao layer to manipulate user objects
	// makes basic crud methods
	
	// these are methods that are not created automatically
	Optional<Customer> findByUsername(String username); //sql infered from name
	
	public List<Customer> findByOrderByLastName(); // returns all in order
	
	public void deleteById(int id);
	
	// how to make a custom query
	@Query("FROM Customer WHERE email LIKE %:pattern")
	public List<Customer> findByEmailContains(); // al/ows us to call a partial email and get the full email "johnsmi" -> return "johnsmith@gmail.com"
	
	
}
