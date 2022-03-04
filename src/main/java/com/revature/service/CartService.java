package com.revature.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.data.CartRepository;
import com.revature.exception.CartNotFoundException;
import com.revature.model.Cart;

@Service
public class CartService {
	
	@Autowired
	CartRepository cartRepo;
	
	public Set<Cart> findAll() {
		return cartRepo.findAll().stream().collect(Collectors.toSet());
	}
	
	public Cart add(Cart s) {
		return cartRepo.save(s);
	}
	
	
	public Cart findById(int id) {
		return cartRepo.findById(id).orElseThrow(() -> new CartNotFoundException("No cart found with this id" + id));
	}
	
	public void remove(int id) {
		cartRepo.deleteById(id);
	}
	
}
