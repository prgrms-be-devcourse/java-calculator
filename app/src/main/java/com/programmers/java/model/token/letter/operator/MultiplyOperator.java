package com.programmers.java.model.token.letter.operator;

public class MultiplyOperator implements Operator {

	private final int priority = 2;

	public MultiplyOperator(String token) {
	}

	public int getPriority() {
		return priority;
	}

	@Override
	public int calculate(int num1, int num2) {
		return num1 * num2;
	}
}
