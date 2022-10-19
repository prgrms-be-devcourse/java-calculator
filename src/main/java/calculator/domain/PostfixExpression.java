package calculator.domain;

import java.util.List;
import java.util.Stack;

import calculator.utils.PostfixParser;
import calculator.utils.ValidatorString;

public class PostfixExpression {

    private final List<String> expression;

    private PostfixExpression(List<String> expression) {
        this.expression = expression;
    }

    public static PostfixExpression from(String expression) {
        return new PostfixExpression(PostfixParser.parse(expression));
    }

    public Double calculate() {
        Stack<Double> stack = new Stack<>();

        for (String value : expression) {
            if (ValidatorString.isNumber(value)) {
                stack.add(Double.valueOf(value));
                continue;
            }

            if (ValidatorString.isOperator(value)) {
                double secondNumber = stack.pop();
                double firstNumber = stack.pop();
                stack.add(OperatorType.from(value).calculate(firstNumber, secondNumber));
            }
        }
        return stack.pop();
    }
}
