package com.programmers.java.exception;

public class WrongBracketCountException extends RuntimeException {

	private static final String errorMessage = "괄호의 짝이 맞지 않습니다.";

	public WrongBracketCountException() {
		super(errorMessage);
	}
}
