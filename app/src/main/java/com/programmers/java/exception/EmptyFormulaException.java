package com.programmers.java.exception;

public class EmptyFormulaException extends Exception {

	private static final String errorMessage = "빈 계산식입니다." + System.lineSeparator() + System.lineSeparator();

	public EmptyFormulaException() {
		super(errorMessage);
	}
}
