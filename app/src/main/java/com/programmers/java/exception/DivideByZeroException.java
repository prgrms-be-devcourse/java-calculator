package com.programmers.java.exception;

public class DivideByZeroException extends RuntimeException {

	private static final String errorMessage = "0으로 나누면 안됩니다." + System.lineSeparator() + System.lineSeparator();

	public DivideByZeroException() {
		super(errorMessage);
	}
}
