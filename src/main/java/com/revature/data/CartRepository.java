package com.revature.data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{

}
