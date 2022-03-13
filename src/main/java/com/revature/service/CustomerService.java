package com.revature.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.data.CartRepository;
import com.revature.data.CustomerRepository;
import com.revature.exception.CustomerNotFoundException;
import com.revature.model.Cart;
import com.revature.model.Customer;

@Service
public class CustomerService {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CartRepository cartRepo;
	
	@Autowired
	CustomerRepository customerRepo;
	
	// return a set of customers, no duplicates
	// finAll is an automatically generated method
	@Transactional(readOnly=true) // not editing any data
	public Set<Customer> findAll() {
		return customerRepo.findAll().stream().collect(Collectors.toSet());
	}
	
	// findById()
	@Transactional(readOnly=true)
	public Customer getById(int id) {
		
		if(id <= 0) {
			log.warn("Unable to get id for id # {}", id);
		}
		
		
		return customerRepo.getById(id);
	}
	
	// Creates a cart when the customer is added
	@Transactional(propagation=Propagation.REQUIRES_NEW) // creates a new transaction so that methods are isolated if other methods are being called
	public Customer add(Customer c) {
		
		Customer returnedCustomer = customerRepo.save(c);
		
		if(returnedCustomer.getId() > 0) {
			log.info("Successfully returned User with id {}", returnedCustomer.getId());
		} else {
			log.warn("Could not add user with username {}",  c.getUserName());
		}
		
		if(c.getCart() != null) {
			Cart ct =  c.getCart();
			cartRepo.save(ct);
		}

		
		return returnedCustomer;
	}
	
	// add cart to customer
	
	
	@Transactional(propagation=Propagation.REQUIRED) // the default variable, does not create a new transaction 
	public void remove(int id) {
		customerRepo.deleteById(id);
	}
	
	@Transactional(readOnly=true)
	public Customer getByUserName(String userName) {
		return customerRepo.findByUserName(userName).orElseThrow(() -> new CustomerNotFoundException("No customer found with this username" + userName));
	}
	
	
	
}
