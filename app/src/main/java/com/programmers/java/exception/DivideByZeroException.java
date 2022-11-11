package com.programmers.java.exception;

public class DivideByZeroException extends RuntimeException {

	private static final String errorMessage = "0으로 나누면 안됩니다.";

	public DivideByZeroException() {
		super(errorMessage);
	}
}
