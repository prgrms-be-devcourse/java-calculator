package com.programmers.engine.model;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b);

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> biFunction;

    Operator(String operator, BiFunction<Integer, Integer, Integer> biFunction) {
        this.operator = operator;
        this.biFunction = biFunction;
    }

    public static Operator getOperator(String input) {
        return Arrays.stream(Operator.values())
                .filter(o -> Objects.equals(o.operator, input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 연산자 입니다."));
    }

    public Integer calculate(Integer operand1, Integer operand2) {
        return biFunction.apply(operand1, operand2);
    }
}
