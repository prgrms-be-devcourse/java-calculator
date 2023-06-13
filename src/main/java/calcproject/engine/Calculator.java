package calcproject.engine;

import java.util.List;

public class Calculator {
	private CalcExpressionTokenizer calcExpressionTokenizer;

	public Calculator(CalcExpressionTokenizer calcExpressionTokenizer) {
		this.calcExpressionTokenizer = calcExpressionTokenizer;
	}

	public double calculateExpression(String expression) {
		List<String> tokens = calcExpressionTokenizer.tokenizeExpression(expression);
		return Double.NaN;
	}
}
