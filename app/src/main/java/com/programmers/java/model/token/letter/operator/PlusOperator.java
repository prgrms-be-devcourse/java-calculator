package com.programmers.java.model.token.letter.operator;

public class PlusOperator implements Operator {

	private final int priority = 1;

	public PlusOperator(String token) {
	}

	public int getPriority() {
		return priority;
	}

	@Override
	public int calculate(int num1, int num2) {
		return num1 + num2;
	}
}
