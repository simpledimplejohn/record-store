package com.revature.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AlbumNotFoundException extends RuntimeException {
	public AlbumNotFoundException(String message) {
		super(message);
	}
}
