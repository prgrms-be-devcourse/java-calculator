package calcproject.engine;

import java.util.Arrays;

public enum Operator {
	Plus("+", 0),
	Minus("-", 0),
	Multiply("*", 1),
	Divide("/", 1),
	UnSupportedOp("", -1);

	private String operator;
	private int priority;

	Operator(String operator, int priority) {
		this.operator = operator;
		this.priority = priority;
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
}
