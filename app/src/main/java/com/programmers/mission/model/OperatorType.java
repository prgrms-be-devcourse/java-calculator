package com.programmers.mission.model;

import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;

import com.programmers.mission.exception.ZeroDivisionException;
import com.programmers.mission.message.ErrorMessage;

public enum OperatorType {
	ADDICTIVE(2, Long::sum),
	MINUS(2, (left, right) -> left - right),
	MULTIPLICATION(1, (left, right) -> left * right),
	DIVISION(1, (left, right) -> {
		if (right == 0) {
			throw new ZeroDivisionException(ErrorMessage.ZERO_DIVISION_ERROR);
		}
		return left / right;
	});

	private static final Map<String, OperatorType> operatorMap = Map.of(
			"+", ADDICTIVE,
			"-", MINUS,
			"*", MULTIPLICATION,
			"/", DIVISION
	);

	private final int priority;
	private final BinaryOperator<Long> operator;

	OperatorType(int priority, BinaryOperator<Long> operator) {
		this.priority = priority;
		this.operator = operator;
	}

	public boolean isHighPriority(OperatorType opponent) {
		return this.priority <= opponent.priority;
	}

	public long operate(long left, long right) {
		return this.operator.apply(left, right);
	}

	public static Optional<OperatorType> getValue(String operator) {
		return Optional.ofNullable(operatorMap.get(operator));
	}

}