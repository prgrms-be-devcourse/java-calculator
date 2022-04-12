package com.programmers.mission.model;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Optional;

import com.programmers.mission.exception.NotSupportedOperatorException;
import com.programmers.mission.message.ErrorMessage;
import com.programmers.mission.utils.ParserUtils;
import com.programmers.mission.utils.PatternUtils;

public class CalculationResult {
	private final String expression;
	private final String value;

	public CalculationResult(String expression) {
		this.expression = expression;
		this.value = calculate(this.expression);
	}

	@Override
	public String toString() {
		return expression + " = " + value;
	}

	public String getValue() {
		return this.value;
	}

	private List<String> toPostFix(String expression) {
		List<String> postFix = new ArrayList<>();
		Deque<String> operatorPocket = new ArrayDeque<>();
		List<String> splitExpression = ParserUtils.getSplitExpression(expression);

		splitExpression.forEach(token -> {
			ExpressionProperty property = ExpressionProperty.getProperty(token);

			switch (property) {
				case OPERAND -> {
					postFix.add(token);
				}
				case OPERATOR -> {
					proceedOperator(postFix, operatorPocket, token);
				}
			}
		});

		while (!operatorPocket.isEmpty()) {
			postFix.add(operatorPocket.pollLast());
		}

		return postFix;
	}

	private void proceedOperator(List<String> postFix, Deque<String> operatorPocket, String token) {
		if (operatorPocket.isEmpty()) {
			operatorPocket.add(token);
		} else {
			while (!operatorPocket.isEmpty()) {
				OperatorType benchmark = getOperatorType(operatorPocket.peek());
				OperatorType comparison = getOperatorType(token);

				if (benchmark.isHighPriority(comparison)) {
					postFix.add(operatorPocket.pop());
				} else {
					break;
				}
			}

			operatorPocket.add(token);
		}
	}

	private OperatorType getOperatorType(String operator) {
		return OperatorType.getValue(operator)
				.orElseThrow(() -> new NotSupportedOperatorException(ErrorMessage.INTERNAL_ERROR));
	}

	private String calculate(String expression) {
		List<String> postFix = this.toPostFix(expression);
		Deque<Long> numbers = new ArrayDeque<>();

		postFix.forEach(token -> {
			Optional<OperatorType> operator = OperatorType.getValue(token);

			if (operator.isPresent()) {
				Long right = numbers.pollLast();
				Long left = numbers.pollLast();
				numbers.add(operator.get().operate(left, right));
			} else if (PatternUtils.isNumeric(token)) {
				numbers.add(Long.valueOf(token));
			}
		});

		return String.valueOf(numbers.stream().mapToLong(Long::valueOf).sum());
	}
}
