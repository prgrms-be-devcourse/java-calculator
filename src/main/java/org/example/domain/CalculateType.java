package org.example.domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum CalculateType {
    ADD("+", 1, (left, right) -> left + right),
    SUBTRACT("-", 1, (left, right) -> left - right),
    MULTIPLY("*", 2, (left, right) -> left * right),
    DIVIDE("/", 2, (left, right) -> left / right);

    private String symbol;
    private int priority;
    private BiFunction<Double, Double, Double> process;

    CalculateType(String symbol, int priority, BiFunction<Double, Double, Double> process) {
        this.symbol = symbol;
        this.priority = priority;
        this.process = process;
    }

    public double calculate(double left, double right) {
        return process.apply(left, right);
    }

    public int getPriority() {
        return priority;
    }

    private String getSymbol() {
        return symbol;
    }

    public static CalculateType findBySymbol(String symbol) {
        return Arrays.stream(values())
                .filter(calculateType -> calculateType.getSymbol().equals(symbol))
                .findFirst()
                .orElseThrow(()-> new IllegalArgumentException("연산자를 잘못 입력하셨습니다."));
    }
}