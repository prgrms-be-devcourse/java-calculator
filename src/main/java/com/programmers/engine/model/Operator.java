package com.programmers.engine.model;

import lombok.Getter;

import java.util.Arrays;
import java.util.function.BiFunction;

@Getter
public enum Operator {
    ADD("+", 1, (a, b) -> a + b),
    SUBTRACTION("-", 1, (a, b) -> a - b),
    MULTIPLY("*", 2, (a, b) -> a * b),
    DIVIDE("/", 2, (a, b) -> b / a);

    private final String symbol;
    private final int priority;
    private final BiFunction<Integer, Integer, Integer> action;

    Operator(String symbol, int priority, BiFunction<Integer, Integer, Integer> action) {
        this.symbol = symbol;
        this.priority = priority;
        this.action = action;
    }

    public static Operator matchOperator(String operator) {
        return Arrays.stream(values())
                .filter(v -> operator.equals(v.symbol))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public int calculate(int a, int b) {
        return action.apply(a, b);
    }
}
