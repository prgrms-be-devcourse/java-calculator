package calcproject.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Calculator {
	private CalcExpressionTokenizer calcExpressionTokenizer;

	public Calculator(CalcExpressionTokenizer calcExpressionTokenizer) {
		this.calcExpressionTokenizer = calcExpressionTokenizer;
	}

	public double calculateExpression(String expression) {
		List<String> tokens = calcExpressionTokenizer.tokenizeExpression(expression);
		List<String> postfixTokens = toPostfixNotation(tokens);
		double calcResult = calculatePostfixNotation(postfixTokens);

		return calcResult;
	}

	public List<String> toPostfixNotation(List<String> tokens) {
		Stack<String> stack = new Stack<>();
		List<String> postFixNotationTokens = new ArrayList<>();

		for (String currentToken : tokens) {
			if (isNumber(currentToken)) {
				postFixNotationTokens.add(currentToken);
				continue;
			}
			while (!stack.empty()) {
				Operator currentOperator = Operator.opValueOf(currentToken);
				Operator stackPeekOPerator = Operator.opValueOf(stack.peek());

				if (stackPeekOPerator == Operator.UnSupportedOp) {
					return List.of();
				}

				if (currentOperator.getPriority() > stackPeekOPerator.getPriority()) {
					break;
				}

				postFixNotationTokens.add(stack.pop());
			}

			stack.add(currentToken);
		}

		while (!stack.empty()) {
			postFixNotationTokens.add(stack.pop());
		}

		return postFixNotationTokens;
	}

	public double calculatePostfixNotation(List<String> postFixNotationTokens) {
		Stack<Double> stack = new Stack<>();

		for (String token : postFixNotationTokens) {

			if (isNumber(token)) {
				double num = Double.valueOf(token);
				stack.push(num);
			} else {
				Operator operator = Operator.opValueOf(token);

				double operand2 = stack.pop();
				double operand1 = stack.pop();
				double result = operator.calculate(operand1, operand2);
				stack.push(result);
			}
		}

		return stack.pop();
	}

	private boolean isNumber(String token) {
		for (int i = 0; i < token.length(); i++) {
			if (!Character.isDigit(token.charAt(i)))
				return false;
		}
		return true;
	}
}
