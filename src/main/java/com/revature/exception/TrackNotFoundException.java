package com.revature.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TrackNotFoundException extends RuntimeException{
	
	public TrackNotFoundException(String message) {
		super(message);
	}
	
}
