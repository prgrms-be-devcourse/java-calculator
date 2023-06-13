package com.programmers.domain;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.BiFunction;

public enum Operator {
    ADDITION("+", (n1, n2) -> n1 + n2, 1),
    SUBTRACTION("-", (n1, n2) -> n1 - n2, 1),
    MULTIPLICATION("*", (n1, n2) -> n1 * n2, 2),
    DIVISION("/", (n1, n2) -> n1 / n2, 2);

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> expression;
    private final int importance;

    Operator(String operator, BiFunction<Integer, Integer, Integer> expression, int importance) {
        this.operator = operator;
        this.expression = expression;
        this.importance = importance;
    }

    public static Operator findOperator(String input) {
        return Arrays.stream(Operator.values())
                .filter(op -> Objects.equals(op.operator, input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("연산자를 찾을 수 없습니다. = " + input));
    }

    public static int findImportance(String operator) {
        return Arrays.stream(Operator.values())
                .filter(op -> Objects.equals(op.operator, operator))
                .map(op -> op.importance)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("우선순위를 찾을 수 없습니다. = " + operator));
    }

    public int calculate(int num1, int num2) {
        return this.expression.apply(num1, num2);
    }
}