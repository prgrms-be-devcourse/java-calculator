package com.programmers.util;

import com.programmers.exception.DivisionByZeroException;
import com.programmers.exception.NotFoundOperatorException;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
	
	PLUS("+", -1, (a, b) -> { return a + b; }),
	MINUS("-", -1, (a, b) -> { return a - b; }),
	DIVIDE("/", 1, (a, b) -> {
		try {
			return a / b;
		} catch (ArithmeticException e) {
			throw new DivisionByZeroException("0으로 나눌 수 없습니다.");
		}
	}),
	MUTIPLY("*", 1, (a, b) -> { return a * b; });
	
	private final String operator;
	private final int priority;
	private final BiFunction<Integer, Integer, Integer> calculation;
	
	Operator(String operator, int priority, BiFunction<Integer, Integer, Integer> calculation) {
		this.operator = operator;
		this.priority = priority;
		this.calculation = calculation;
	}
	
	public static Operator of(String operator) {
		return Arrays.stream(Operator.values())
				.filter(o -> o.operator.equals(operator))
				.findFirst()
		        .orElseThrow(() -> new NotFoundOperatorException("찾을 수 없는 연산자입니다."));
	}
	
	public int getPriority() {
		return priority;
	}
	
	public Integer calculateOperation(Integer op1, Integer op2) {
		return calculation.apply(op1, op2);
	}
	
}
