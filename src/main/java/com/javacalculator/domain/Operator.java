package com.javacalculator.domain;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Operator {
    ADDITION("+", (e1, e2) -> e1 + e2),
    SUBTRACTION("-", (e1, e2) -> e1 - e2),
    MULTIPLICATION("*", (e1, e2) -> e1 * e2),
    DIVISION("/", (e1, e2) -> e1 / e2);

    private final String symbol;
    private final BinaryOperator<Integer> expression;

    Operator(String symbol, BinaryOperator<Integer> expression) {
        this.symbol = symbol;
        this.expression = expression;
    }

    public static Operator from(String symbol) {
        return Arrays.stream(values())
                .filter(operator -> operator.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        "입력된 기호는 사칙연산 기호가 아닙니다. : " + symbol));
    }

    public int operate(int e1, int e2) {
        return expression.apply(e1, e2);
    }
}
