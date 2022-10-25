package com.programmers.java.model.token.letter.operator;

public class MinusOperator implements Operator {

	private final int priority = 1;

	public MinusOperator(String token) {
	}

	public int getPriority() {
		return priority;
	}

	@Override
	public int calculate(int num1, int num2) {
		return num1 - num2;
	}
}
