package com.programmers.calculator.engine.calculation;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Symbol {
    ADD("+", (num1, num2) -> num1 + num2),
    SUBTRACT("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> {
        if (num2 == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return num1 / num2;
    });


    private String symbol;
    private BiFunction<Double, Double, Double> formula;

    Symbol(String symbol, BiFunction<Double, Double, Double> formula) {
        this.symbol = symbol;
        this.formula = formula;
    }

    public static double calculate(String symbol, double num1, double num2) {
        return getSymbol(symbol).formula.apply(num1, num2);
    }

    private static Symbol getSymbol(String symbol) {
        return Arrays.stream(values())
                .filter(o -> o.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException(symbol + " 은 올바른 연산자가 아닙니다."));
    }
}
