package com.programmers.java.model.token.letter;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import com.programmers.java.model.token.number.Numbers;

public enum Operator implements Letter {
	PLUS("+", 1, (num1, num2) -> num1 + num2),
	MINUS("-", 1, (num1, num2) -> num1 - num2),
	MULTIPLY("*", 2, (num1, num2) -> num1 * num2),
	DIVIDE("/", 2, (num1, num2) -> {
		if (num2 == 0) {
			throw new ArithmeticException();
		}
		return num1 / num2;
	});

	private String type;
	private int priority;
	private BiFunction<Integer, Integer, Integer> calculateFunction;

	Operator(String type, int priority,
		BiFunction<Integer, Integer, Integer> calculateFunction) {
		this.type = type;
		this.priority = priority;
		this.calculateFunction = calculateFunction;
	}

	public static boolean isOperator(String token) {
		return Arrays.stream(Operator.values())
			.map(o -> o.getValue())
			.collect(Collectors.toList())
			.contains(token);
	}

	public static Operator getOperatorType(String type) {
		return Arrays.stream(Operator.values())
			.filter(t -> t.type.equals(type))
			.findFirst()
			.orElseThrow();
	}

	public int calculate(int num1, int num2) {
		return calculateFunction.apply(num1, num2);
	}

	@Override
	public String getValue() {
		return type;
	}

	@Override
	public boolean checkNextTokenCorrect(String nextToken) {
		return (Numbers.isNumbers(nextToken) || nextToken.equals("("));
	}

	@Override
	public int getPriority() {
		return priority;
	}
}
