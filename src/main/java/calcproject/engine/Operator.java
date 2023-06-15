package calcproject.engine;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
	Plus("+", 0, (a, b) -> a + b),
	Minus("-", 0, (a, b) -> a - b),
	Multiply("*", 1, (a, b) -> a * b),
	Divide("/", 1, (a, b) -> a / b),
	UnSupportedOp("", -1, (a,b) -> Double.NaN);

	private String operator;
	private int priority;
	private Calculable calculable;

	Operator(String operator, int priority, Calculable calculable) {
		this.operator = operator;
		this.priority = priority;
		this.calculable = calculable;
	}

	public static Operator opValueOf(String op) {
		return Arrays.stream(values())
			.filter(
				value -> value
					.getOperator()
					.equals(op)
			)
			.findAny()
			.orElse(Operator.UnSupportedOp);
	}

	public String getOperator() {
		return this.operator;
	}

	public int getPriority() {
		return this.priority;
	}

	public double calculate(double num1, double num2) {
		return this.calculable.calculate(num1, num2);
	}
}
