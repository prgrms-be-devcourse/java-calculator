package com.programmers.util;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", 1, (num1, num2)-> num1 + num2),
    MINUS("-", 1, (num1, num2)-> num1 - num2),
    MULTIPLY("*", 2, (num1, num2)-> num1 * num2),
    DIVIDE("/", 2, (num1, num2)-> num1 / num2),
    OPEN_BRACKET("(", 0, null),
    CLOSE_BRACKET(")", 0, null);

    private final String operator;
    private final int priority;
    private final BiFunction<Double, Double, Double> biFunction;

    Operator(String operator, int priority, BiFunction<Double, Double, Double> biFunction) {
        this.operator = operator;
        this.priority = priority;
        this.biFunction = biFunction;
    }

    public static boolean contains(String cur) {
        return Arrays.stream(Operator.values())
                .anyMatch(operator -> operator.getOperator().equals(cur));
    }

    public String getOperator() {
        return operator;
    }

    public int getPriority() {
        return priority;
    }

}
