package com.revature.controller;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Customer;
import com.revature.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	
	@Autowired
	CustomerService custServ;
	
	// get request
	@GetMapping
	public Set<Customer> getAll() {
		// has Jackson automatically converting to JSON
		return custServ.findAll();
	}
	
	// find by username
	@GetMapping("/find/{username}")
	public Customer findByUserName(@PathVariable("username") String username) {
		
		return custServ.getByUserName(username);
		
	}
	
	@PostMapping("/add") // will check all against the validation in the model
	public Customer addCustomer(@Valid @RequestBody Customer c) { //gets customer from request body, makes sure its valid
		
		return custServ.add(c); //the return is the json data from the post request
		
	}
	
	@GetMapping("/{custId}")
	public Customer getById(@PathVariable("custId") int id) {
		return custServ.getById(id);
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") int id) {
		
		custServ.remove(id);
		
	}


	
	
}
