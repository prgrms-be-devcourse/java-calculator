package com.programmers.calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
	
	PLUS("+", (a, b) -> { return a + b; }),
	MINUS("-", (a, b) -> { return a - b; }),
	DIVIDE("/", (a, b) -> {
		try {
			return a / b;
		} catch (ArithmeticException e) {
			throw e;
		}
	}),
	MUTIPLY("*", (a, b) -> { return a * b; });
	
	private String operator;
	private BiFunction<Integer, Integer, Integer> func;
	
	Operator(String operator, BiFunction<Integer, Integer, Integer> func) {
		this.operator = operator;
		this.func = func;
	}
	
	public String getOperator() {
		return operator;
	}
	
	public BiFunction<Integer, Integer, Integer> getFunc() {
		return func;
	}
	
	public static Operator of(String operator) {
		return Arrays.stream(Operator.values())
				.filter(o -> o.getOperator().equals(operator))
				.findFirst()
		        .orElseThrow(NullPointerException::new);
	}
	
}
