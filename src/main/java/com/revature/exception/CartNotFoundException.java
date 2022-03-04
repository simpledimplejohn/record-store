package com.revature.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CartNotFoundException extends RuntimeException{
	/**
	 * 
	 */


	public CartNotFoundException(String message) {
		super(message);
	}
}
