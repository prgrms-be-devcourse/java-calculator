package calcproject.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Calculator {
	private CalcExpressionTokenizer calcExpressionTokenizer;

	public Calculator(CalcExpressionTokenizer calcExpressionTokenizer) {
		this.calcExpressionTokenizer = calcExpressionTokenizer;
	}

	private boolean isNumber(String token) {
		for (int i=0; i<token.length(); i++){
			if(!Character.isDigit(token.charAt(i)))
				return false;
		}
		return true;
	}

	public List<String> tokensToPostfixNotation(List<String> tokens) {
		Stack<String> stack = new Stack<>();
		List<String> postFixNotationTokens = new ArrayList<>();
		for (String currentToken : tokens) {
			if (isNumber(currentToken)) {
				postFixNotationTokens.add(currentToken);
				continue;
			}

			while(!stack.empty()) {
				Operator currentOperator = Operator.opValueOf(currentToken);
				Operator stackPeekOPerator = Operator.opValueOf(stack.peek());

				if ( stackPeekOPerator == Operator.UnSupportedOp) {
					return null;
				}

				if ( currentOperator.getPriority() > stackPeekOPerator.getPriority()) {
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

	public double calculateExpression(String expression) {
		List<String> tokens = calcExpressionTokenizer.tokenizeExpression(expression);


		return Double.NaN;
	}
}
