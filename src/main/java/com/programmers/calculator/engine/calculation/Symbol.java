package com.programmers.calculator.engine.calculation;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Symbol {
    ADD("+", (num1, num2) -> num1 + num2),
    SUBTRACT("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("%", (num1, num2) -> num1 / num2);

    private String symbol;
    private BiFunction<Double, Double, Double> expression;

    Symbol(String symbol, BiFunction<Double, Double, Double> expression) {
        this.symbol = symbol;
        this.expression = expression;
    }

    public static double calculate(String symbol, double num1, double num2) {
        return getSymbol(symbol).expression.apply(num1, num2);
    }

    private static Symbol getSymbol(String symbol) {
        return Arrays.stream(values())
                .filter(o -> o.symbol.equals(symbol))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("올바른 연산자가 아닙니다."));
    }
}
