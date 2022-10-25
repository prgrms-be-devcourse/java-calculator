package com.programmers.java.model.token.letter.operator;

import com.programmers.java.exception.DivideByZeroException;

public class DivideOperator implements Operator {

	private final int priority = 2;

	public DivideOperator(String token) {
	}

	public int getPriority() {
		return priority;
	}

	@Override
	public int calculate(int num1, int num2) throws DivideByZeroException {
		try {
			return num1 / num2;
		} catch (Exception e) {
			throw new DivideByZeroException();
		}
	}
}
