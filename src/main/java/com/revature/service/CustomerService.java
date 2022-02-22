package com.revature.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.data.CustomerRepository;
import com.revature.exception.CustomerNotFoundException;
import com.revature.model.Customer;

@Service
public class CustomerService {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
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
		return customerRepo.getById(id);
	}
	
	// insert
	@Transactional(propagation=Propagation.REQUIRES_NEW) // creates a new transaction so that methods are isolated if other methods are being called
	public Customer add(Customer c) {
		return customerRepo.save(c);
	}
	
	@Transactional(propagation=Propagation.REQUIRED) // the default variable, does not create a new transaction 
	public void remove(int id) {
		customerRepo.deleteById(id);
	}
	
	@Transactional(readOnly=true)
	public Customer getByUserName(String userName) {
		return customerRepo.findByUserName(userName).orElseThrow(() -> new CustomerNotFoundException("No customer found with this username" + userName)) ;
	}
	
	
	
}
