package com.programmers.java.exception;

public class WrongTokenOrderException extends RuntimeException {

	private static final String errorMessage = "계산식 문자의 순서가 잘못되었습니다.";

	public WrongTokenOrderException() {
		super(errorMessage);
	}
}
