package co.programmers.domain;

import java.util.ArrayList;

public class Calculation {

	private ArrayList<String> parsedExpression;
	private ArrayList<String> operators;
	private Expression expression;

	public Calculation(Expression expression) {
		this.expression = expression;
		parsedExpression = new ArrayList<>();
		operators = new ArrayList<>();
	}

	public Double calculate() throws ArithmeticException {
		parsedExpression = expression.split();
		operators = extractOperators();
		Operator.decideCalculationOrder(operators);
		for (String operator : operators) {
			int operatorPosition = parsedExpression.indexOf(operator);
			Double[] operands = extractOperands(operator);
			Double calculationRes = Operator.calculate(operator, operands[0], operands[1]);
			storeIntermediateResult(operatorPosition, calculationRes);
			removeCompletedExpression(operatorPosition, operands.length);
		}
		return calcFinalResult();
	}

	private void removeCompletedExpression(int operatorPosition, int count) {
		for (int cnt = 0; cnt < count; cnt++) {
			parsedExpression.remove(operatorPosition);
		}
	}

	private void storeIntermediateResult(int operatorPosition, Double calculationRes) {
		parsedExpression.add(operatorPosition - 1, String.valueOf(calculationRes));
	}

	private Double[] extractOperands(String operator) {
		int operatorIdx = parsedExpression.indexOf(operator);
		Double operand1 = Double.parseDouble(parsedExpression.get(operatorIdx - 1));
		Double operand2 = Double.parseDouble(parsedExpression.get(operatorIdx + 1));
		return new Double[] {operand1, operand2};
	}

	public ArrayList<String> extractOperators() {
		expression.eliminateWhiteSpace();
		ArrayList<String> parsed = expression.split("\\d+");
		parsed.removeIf(String::isEmpty);
		return parsed;
	}

	private Double calcFinalResult() {
		return Double.parseDouble(parsedExpression.get(0));
	}
}
