package com.programmers.java.exception;

public class MenuInputException extends RuntimeException {

	private static final String errorMessage = "메뉴의 숫자를 입력해주세요.";

	public MenuInputException() {
		super(errorMessage);
	}
}