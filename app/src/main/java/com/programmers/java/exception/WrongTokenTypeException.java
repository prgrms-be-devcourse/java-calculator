package com.programmers.java.exception;

public class WrongTokenTypeException extends Exception {

	private static final String errorMessage =
		"계산식에 들어올 수 없는 문자가 있습니다." + System.lineSeparator() + System.lineSeparator();

	public WrongTokenTypeException() {
		super(errorMessage);
	}
}
