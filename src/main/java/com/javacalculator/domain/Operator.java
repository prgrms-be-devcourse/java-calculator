package com.javacalculator.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Operator {
    ADDITION("+", (e1, e2) -> e1 + e2, 1),
    SUBTRACTION("-", (e1, e2) -> e1 - e2, 1),
    MULTIPLICATION("*", (e1, e2) -> e1 * e2, 0),
    DIVISION("/", (e1, e2) -> e1 / e2, 0);

    private static final Map<String, Operator> operators =
            Collections.unmodifiableMap(Arrays.stream(values())
                    .collect(Collectors.toMap(Operator::getSymbol, Function.identity())));

    private final String symbol;
    private final BinaryOperator<Integer> expression;
    private final int priority;

    Operator(String symbol, BinaryOperator<Integer> expression, int priority) {
        this.symbol = symbol;
        this.expression = expression;
        this.priority = priority;
    }

    public static Operator from(String symbol) {
        return Optional.ofNullable(operators.get(symbol))
                .orElseThrow(() -> new IllegalArgumentException(
                        "입력된 기호는 사칙연산 기호가 아닙니다. : " + symbol));
    }

    public int operate(int e1, int e2) {
        return expression.apply(e1, e2);
    }

    public boolean isSame(int priority) {
        return this.priority == priority;
    }

    public String getSymbol() {
        return symbol;
    }
}
