package com.revature.controller;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Album;
import com.revature.model.Cart;
import com.revature.model.Customer;
import com.revature.service.AlbumService;
import com.revature.service.CartService;
import com.revature.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	CartService cartServ;
	
	@Autowired
	CustomerService custServ;
	
	@Autowired
	AlbumService albServ;
	
	// get request
	@GetMapping
	public Set<Customer> getAll() {
		// has Jackson automatically converting to JSON
		return custServ.findAll();
	}
	
	// find by username
	@GetMapping("/find/{username}")
	public ResponseEntity<Customer> findByUserName(@PathVariable("username") String username) {
		
		return ResponseEntity.ok(custServ.getByUserName(username));
		
	}
	// may not need response entity... but useful
	@PostMapping("/add") // will check all against the validation in the model
	public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer c) { //gets customer from request body, makes sure its valid
		

		return ResponseEntity.ok(custServ.add(c)); //the return is the json data from the post request
		
	}

// add cart to existing customer
	@PutMapping("/{id}/addCart")
	public Customer addCartToCustomer(@RequestBody Cart ct, @PathVariable("id") int id) {
		
		// get the customer from id
		Customer c = custServ.getById(id);
		// set the customer to the cart
		ct.setCustomer(c);
		// add the cart 
		cartServ.add(ct);
		
		
		return c;
	}

// add album to customers cart
//	@PutMapping("/{id}/addAlbumToCart")
//	public Customer addAlbumToCart(@RequestBody Album a, @PathVariable("id") int id) {
//		
//		double price = a.getPrice();
//		
//		albServ.add(a);
//		
//		Customer c = custServ.getById(id);
//		
//		Cart ct = c.getCart();
//		
//		List<Album> albumList = ct.getAlbums();
//		
//		albumList.add(a);
//		
//		ct.setAlbums(albumList);
//		System.out.println(ct);
//		
//		price += ct.getTotal();
//		
//		ct.setTotal(price);
//		
//		if(ct.getAlbums() != null) {
//			ct.setAlbums(null);			
//		}
//		
//		c.setCart(ct);
//		
//		
//		
//		return c;
//	}
	
	
	// sometimes this won't work, 
	// GetMapping is sposed to put the request in the reponse body, but it needs a bit of help
	// must be done manually by using ResponseEnitty in the method signature and in the return type
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> findCustomerById(@PathVariable("id") int id) {
		return ResponseEntity.ok(custServ.getById(id));
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") int id) {
		
		custServ.remove(id);
		
	}


	
	
}
