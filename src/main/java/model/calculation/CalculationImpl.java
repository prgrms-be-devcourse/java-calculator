package model.calculation;

import constant.Operator;

import java.util.List;
import java.util.Stack;

public class CalculationImpl implements Calculation{
    private static final String IS_NUMBER_PATTERN = "^[0-9]$";

    @Override
    public int calculate(List<String> postfixExpression) {
        Stack<Integer> stack = new Stack<>();

        for (String textSegment : postfixExpression) {
            if (isNumber(textSegment)) {
                stack.push(Integer.parseInt(textSegment));
                continue;
            }

            int number1 = stack.pop();
            int number2 = stack.pop();
            Operator operator = Operator.findOperator(textSegment);
            switch (operator) {
                case PLUS -> stack.push(plus(number1, number2));
                case MINUS -> stack.push(minus(number1, number2));
                case MULTIPLY -> stack.push(multiply(number1, number2));
                case DIVIDE -> stack.push(divide(number1, number2));
            }
        }

        return stack.pop();
    }

    private boolean isNumber(String s) {
        return s.matches(IS_NUMBER_PATTERN);
    }
}
