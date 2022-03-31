package com.programmers.java.enums;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiFunction;

public enum Operator {
    DIVISION("/", 1, (a, b) -> a / b),
    MULTIPLY("*", 1, (a, b) -> a * b),
    ADD("+", 0, (a, b) -> a + b),
    MINUS("-", 0, (a, b) -> a - b);

    private String operator;
    private int priority;
    private BiFunction<Integer, Integer, Integer> expression;

    Operator(String operator, int priority, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.priority = priority;
        this.expression = expression;
    }

    public static int calculate(String operator, int num1, int num2) {
        return getOperator(operator).expression.apply(num2, num1);
    }

    public static int comparePriority(String operator1, String operator2) {
        return getOperator(operator1).getPriority() - getOperator(operator2).getPriority();
    }

    private static Operator getOperator(String operator) {
        return Arrays.stream(values())
                .filter(Objects::nonNull)
                .filter(o -> o.operator.equals(operator))
                .findFirst().get();
    }

    private int getPriority() {
        return priority;
    }


}
