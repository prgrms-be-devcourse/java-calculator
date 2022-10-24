package calculator.operation;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import calculator.validator.Validator;

public class OperationManager implements Service {

	private final Validator validator;

	public OperationManager(Validator validator) {
		this.validator = validator;
	}

	@Override
	public List<String> toPostFix(List<String> tokens) {

		Deque<String> deque = new ArrayDeque<>();
		List<String> postFix = new ArrayList<>();
		for (String s : tokens) {

			if (validator.isNumber(s)) {
				postFix.add(s);
			} else {
				Operation operation = Operation.getOperator(s);
				while (!deque.isEmpty()
					&& operation.getPriority().compareTo(Operation.getOperator(deque.peek()).getPriority())
					< 0) {
					postFix.add(deque.pop());
				}
				deque.push(s);
			}

		}
		while (!deque.isEmpty()) {
			postFix.add(deque.pop());
		}
		return postFix;

	}

	@Override
	public String calculate(List<String> postFix) {

		Deque<String> deque = new ArrayDeque<>() {
		};
		for (String s : postFix) {
			if (validator.isNumber(s)) {
				deque.push(s);
			} else {
				double second = Double.parseDouble(deque.pop());
				double first = Double.parseDouble(deque.pop());
				Operation operation = Operation.getOperator(s);
				String calculate = String.valueOf(operation.calculate(first, second));
				deque.push(calculate);
			}
		}

		return deque.pop();

	}

}
