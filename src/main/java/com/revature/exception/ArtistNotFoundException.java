package com.revature.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ArtistNotFoundException extends RuntimeException{
	public ArtistNotFoundException(String message) {
		super(message);
	}
}
