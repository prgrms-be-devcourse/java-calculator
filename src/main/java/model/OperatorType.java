package model;

import exception.NoSuchOperatorException;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum OperatorType {
    PLUS("+", 0, (num1, num2) -> num1 + num2),
    MINUS("-", 0, (num1, num2) -> num1 - num2),
    MULTIPLY("*", 1, (num1, num2) -> num1 * num2),
    DIVIDE("/", 1, (num1, num2) -> num1 / num2);

    private final String operator;
    private final int precedence;
    private final BiFunction<Integer, Integer, Integer> expression;

    OperatorType(String operator, int precedence, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.precedence = precedence;
        this.expression = expression;
    }

    public static OperatorType getOperator(String operator) {
        return Arrays.stream(values())
                .filter(elem -> elem.operator.equals(operator))
                .findFirst()
                .orElseThrow(NoSuchOperatorException::new);
    }

    public int getPrecedence() {
        return precedence;
    }

    public int applyCalculate(int num1, int num2) {
        return expression.apply(num1, num2);
    }
}
