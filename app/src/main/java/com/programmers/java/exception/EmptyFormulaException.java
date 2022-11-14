package com.programmers.java.exception;

public class EmptyFormulaException extends RuntimeException {

	private static final String errorMessage = "빈 계산식입니다.";

	public EmptyFormulaException() {
		super(errorMessage);
	}
}
