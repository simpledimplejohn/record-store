package com.revature.data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.ShopingCart;

@Repository
public interface CartRepository extends JpaRepository<ShopingCart, Integer>{
	Optional<ShopingCart> findByShopingCartDate(String date);
}
