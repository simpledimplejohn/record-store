package com.revature.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Cart;
import com.revature.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	CartService cartServ;
	
	@GetMapping
	public Set<Cart> getall() {
		return cartServ.findAll();
	}
	

	
	@GetMapping("/{id}")
	public Cart findById(@PathVariable("id") int id) {
		return cartServ.findById(id);
	}
	
	@PostMapping("/add")
	public Cart add(@RequestBody Cart s) {
		return cartServ.add(s);
	}
	
}
