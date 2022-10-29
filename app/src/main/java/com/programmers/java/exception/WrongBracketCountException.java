package com.programmers.java.exception;

public class WrongBracketCountException extends Exception {

	private static final String errorMessage = "괄호의 짝이 맞지 않습니다." + System.lineSeparator() + System.lineSeparator();

	public WrongBracketCountException() {
		super(errorMessage);
	}
}
