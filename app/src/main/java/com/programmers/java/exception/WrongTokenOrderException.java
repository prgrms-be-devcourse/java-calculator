package com.programmers.java.exception;

public class WrongTokenOrderException extends Exception {

	private static final String errorMessage = "계산식 문자의 순서가 잘못되었습니다." + System.lineSeparator() + System.lineSeparator();

	public WrongTokenOrderException() {
		super(errorMessage);
	}
}
