package model;

import exception.NoSuchOperatorException;


import java.util.*;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", 0, (num1, num2) -> num1 + num2),
    MINUS("-", 0, (num1, num2) -> num1 - num2),
    MULTIPLY("*", 1, (num1, num2) -> num1 * num2),
    DIVIDE("/", 1, (num1, num2) -> num1 / num2);

    private final String operator;
    private final int precedence;
    private final BiFunction<Integer, Integer, Integer> expression;

    Operator(String operator, int precedence, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.precedence = precedence;
        this.expression = expression;
    }

    public static Operator getOperator(String operator) {
        return Arrays.stream(values())
                .filter(elem -> elem.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new NoSuchOperatorException("[ERROR] 옳지 않은 연산자입니다."));
    }

    public int getPrecedence() {
        return precedence;
    }

    public int applyCalculate(int num1, int num2) {
        return expression.apply(num1, num2);
    }
}
