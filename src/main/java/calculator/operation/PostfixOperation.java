package calculator.operation;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import calculator.validator.Validator;

public class PostfixOperation implements Operation {

	private final Validator validator;

	public PostfixOperation(Validator validator) {
		this.validator = validator;
	}

	@Override
	public String calculate(List<String> tokens) {

		Deque<String> number = new ArrayDeque<>();
		Deque<String> operator = new ArrayDeque<>();
		List<String> postFix = new ArrayList<>();
		toPostfix(tokens, number, postFix);
		operate(operator, postFix);
		return operator.pop();

	}

	private void operate(Deque<String> operator, List<String> postFix) {
		for (String s : postFix) {
			if (validator.isNumber(s)) {
				operator.push(s);
			} else {
				double second = Double.parseDouble(operator.pop());
				double first = Double.parseDouble(operator.pop());
				Operator operation = Operator.getOperator(s);
				String calculate = String.valueOf(operation.calculate(first, second));
				operator.push(calculate);
			}
		}
	}

	private void toPostfix(List<String> tokens, Deque<String> number, List<String> postFix) {
		for (String token : tokens) {
			if (validator.isNumber(token))
				pushNumber(token, postFix);
			else {
				pushOperation(token, number, postFix);
			}
		}

		while (!number.isEmpty()) {
			postFix.add(number.pop());
		}
	}

	private void pushNumber(String token, List<String> postFix) {
		postFix.add(token);
	}

	private void pushOperation(String token, Deque<String> deque, List<String> postFix) {
		Operator operation1 = Operator.getOperator(token);
		if (!deque.isEmpty()) {
			Operator operation2 = Operator.getOperator(deque.peek());
			if (OperatorPriority.comparePriority(operation1, operation2)) {
				postFix.add(deque.pop());
			}
		}
		deque.push(token);
	}

}
