package calculator;

import java.util.List;
import java.util.Stack;

import calculator.domain.OperatorType;
import calculator.utils.ExpressionParser;

public class Calculator {

    private static final String ERROR_INPUT_FORM = "[ERROR] 정상적인 입력이 아닙니다. 다시 입력해주세요.";

    public Double calculateExpression(List<String> expression) {
        Stack<Double> stack = new Stack<>();

        for (String value : expression) {
            if (isNumber(value)) {
                stack.add(Double.valueOf(value));
                continue;
            }

            if (isOperator(value)) {
                validateStackPop(stack);

                double secondNumber = stack.pop();
                double firstNumber = stack.pop();
                stack.add(calculate(value, firstNumber, secondNumber));
            }
        }

        validateStackSize(stack);

        return roundNumberTwoDecimal(stack.pop());
    }

    private void validateStackSize(Stack<Double> stack) {
        if (stack.size() > 1) {
            throw new IllegalArgumentException(ERROR_INPUT_FORM);
        }
    }

    private void validateStackPop(Stack<Double> stack) {
        if (stack.isEmpty() || stack.size() < 2) {
            throw new IllegalArgumentException(ERROR_INPUT_FORM);
        }
    }

    private double roundNumberTwoDecimal(double result) {
        return Math.round(result * 100) / 100.0;
    }

    public double calculate(String operator, double firstNumber, double secondNumber) {
        return OperatorType.from(operator)
            .calculate(firstNumber, secondNumber);
    }

    private boolean isOperator(String inputString) {
        return ExpressionParser.OPERATOR.matcher(inputString)
            .matches();
    }

    private boolean isNumber(String inputString) {
        return ExpressionParser.NUMBER.matcher(inputString)
            .matches();
    }
}
