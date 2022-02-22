package com.revature.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CustomerNotFoundException extends RuntimeException {
	
	public CustomerNotFoundException(String message) {
		super(message);

		// generated constructor from super class (the class its inheriting and take in
		// a string (the message)

	}

}
