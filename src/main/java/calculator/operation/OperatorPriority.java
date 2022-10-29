package calculator.operation;

import java.util.Arrays;

public enum OperatorPriority {
	PLUS("+", 1),
	MINUS("-", 1),
	MULTIPLY("*", 2),
	DIVIDE("/", 2);

	private final String operator;
	private final int operationPriority;

	OperatorPriority(String operator, int operationPriority) {
		this.operator = operator;
		this.operationPriority = operationPriority;
	}

	public static int getPriority(String operator) {
		return Arrays.stream(OperatorPriority.values())
			.filter(a -> a.operator.equals(operator))
			.findAny()
			.orElseThrow()
			.operationPriority;
	}

	public static boolean comparePriority(Operator operation1, Operator operation2) {
		return getPriority(operation1.getOperator()) < getPriority(operation2.getOperator());
	}

}
