package com.revature.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.data.CartRepository;
import com.revature.exception.CartNotFoundException;
import com.revature.model.ShopingCart;

@Service
public class CartService {
	
	@Autowired
	CartRepository cartRepo;
	
	public Set<ShopingCart> findAll() {
		return cartRepo.findAll().stream().collect(Collectors.toSet());
	}
	
	public ShopingCart add(ShopingCart s) {
		return cartRepo.save(s);
	}
	
	public ShopingCart findByCartDate(String cartDate) {
		return cartRepo.findByShopingCartDate(cartDate).orElseThrow(() -> new CartNotFoundException("No cart found with this date" + cartDate));
	}
	
	public ShopingCart findById(int id) {
		return cartRepo.findById(id).orElseThrow(() -> new CartNotFoundException("No cart found with this id" + id));
	}
	
	public void remove(int id) {
		cartRepo.deleteById(id);
	}
	
}
