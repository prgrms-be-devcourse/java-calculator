package model;

import exception.NoSuchOperatorException;


import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS('+', 0, (num1, num2) -> num1 + num2),
    MINUS('-', 0, (num1, num2) -> num1 - num2),
    MULTIPLY('*', 1, (num1, num2) -> num1 * num2),
    DIVIDE('/', 1, (num1, num2) -> num1 / num2);

    private final char operator;
    private final int precedence;
    private final BiFunction<Integer, Integer, Integer> expression;

    Operator(char operator, int precedence, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.precedence = precedence;
        this.expression = expression;
    }

    public static Operator getOperator(char operator) {
        return Arrays.stream(values())
                .filter(elem -> elem.operator == operator)
                .findFirst()
                .orElseThrow(() -> new NoSuchOperatorException("[ERROR] 옳지 않은 연산자입니다."));
    }

    public int getPrecedence() {
        return precedence;
    }

    public int applyCalculate(int leftOperand, int rightOperand) {
        return expression.apply(leftOperand, rightOperand);
    }
}
