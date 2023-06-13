package com.programmers.domain;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.BiFunction;

public enum Operator {
    ADDITION("+", 1),
    SUBTRACTION("-", 1),
    MULTIPLICATION("*", 2),
    DIVISION("/", 2);

    private final String operator;
    private final int importance;

    Operator(String operator, int importance) {
        this.operator = operator;
        this.importance = importance;
    }

    public static int findImportance(String operator) {
        return Arrays.stream(Operator.values())
                .filter(op -> Objects.equals(op.operator, operator))
                .map(op -> op.importance)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("우선순위를 찾을 수 없습니다. = " + operator));
    }
}