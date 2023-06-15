package co.programmers.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;

import co.programmers.exception.ExceptionMessage;

public enum Operator {
	ADDITION("+", 2, (operand1, operand2) -> operand1 + operand2),
	SUBTRACTION("-", 2, (operand1, operand2) -> operand1 - operand2),
	MULTIPLICATION("*", 1, (operand1, operand2) -> operand1 * operand2),
	DIVISION("/", 1, (operand1, operand2) -> {
		if (operand2 == 0) {
			throw new ArithmeticException(ExceptionMessage.DIVIDED_BY_ZERO);
		}
		return operand1 / operand2;
	});

	private final String symbol;
	private final int priority;
	private final BiFunction<Double, Double, Double> operation;

	private Operator(String symbol, int priority, BiFunction<Double, Double, Double> operation) {
		this.symbol = symbol;
		this.priority = priority;
		this.operation = operation;
	}

	public static Double calculate(String operator, Double operand1, Double operand2) {
		return getSymbol(operator).operation.apply(operand1, operand2);
	}

	public static Operator getSymbol(Object operator) {
		return Arrays.stream(values())
				.filter(o -> o.symbol.equals(operator))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.INVALID_INPUT));
	}

	public static void decideCalculationOrder(List<String> operators) {
		Collections.sort(operators, (operator1, operator2) ->
				Integer.compare(getSymbol(operator1).getPriority(), getSymbol(operator2).getPriority())
		);
	}

	public int getPriority() {
		return priority;
	}
}
