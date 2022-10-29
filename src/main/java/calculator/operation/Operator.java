package calculator.operation;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {

	PLUS("+", (first, second) -> first + second),
	MINUS("-", (first, second) -> first - second),
	DIVIDE("/", (first, second) -> first / second),
	MULTIPLY("*", (first, second) -> first * second),
	;

	private final String operator;
	private final BiFunction<Double, Double, Double> concreteOperator;

	Operator(String operator, BiFunction<Double, Double, Double> calculateFunction) {

		this.operator = operator;
		this.concreteOperator = calculateFunction;
	}

	public static Operator getOperator(String token) {
		return Arrays.stream(Operator.values())
			.filter(a -> a.operator.equals(token))
			.findAny()
			.orElseThrow();

	}

	public double calculate(double first, double second) {
		return concreteOperator.apply(first, second);
	}

	public String getOperator() {
		return operator;
	}
}


