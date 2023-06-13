package com.programmers.java.calculator.model;

import java.math.BigDecimal;
import java.util.function.BiFunction;

public enum Operator {

    ADDITION("+", 2, BigDecimal::add),
    SUBTRACTION("-", 2, BigDecimal::subtract),
    MULTIPLICATION("*", 1, BigDecimal::multiply),
    DIVISION("/", 1, BigDecimal::divide);

    private final String symbol;
    private final int priority;
    private final BiFunction<BigDecimal, BigDecimal, BigDecimal> function;

    Operator(String symbol, int priority, BiFunction<BigDecimal, BigDecimal, BigDecimal> function) {
        this.symbol = symbol;
        this.priority = priority;
        this.function = function;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getPriority() {
        return priority;
    }

    public int comparePriority(Operator operator) {
        if (this.getPriority() > operator.getPriority()) return -1;
        if (this.getPriority() < operator.getPriority()) return 1;
        return 0;
    }

    public BigDecimal calculate(BigDecimal a, BigDecimal b) {
        return this.function.apply(a, b);
    }

    public static Operator of(String symbol) {
        for (Operator operator : Operator.values()) {
            if (operator.getSymbol().equals(symbol)) {
                return operator;
            }
        }

        throw new IllegalArgumentException("잘못 입력되었습니다");
    }
}
