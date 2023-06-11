package org.example.exception;

import lombok.Getter;

@Getter
public class CaculatorApplicationException extends RuntimeException {
	private String message;

	public CaculatorApplicationException(String message) {
		this.message = message;
	}

}
