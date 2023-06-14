package com.programmers.calculator.domain;

import java.math.BigDecimal;
import java.util.function.BiFunction;

public enum Operator {
    ADDITION('+', 10, BigDecimal::add),
    SUBTRACTION('-', 10, BigDecimal::subtract),
    MULTIPLICATION('*', 100, BigDecimal::multiply),
    DIVISION('/', 100, BigDecimal::divide);

    private static final Operator[] OPERATORS = Operator.values();

    private final char symbol;
    private final int priority;
    private final BiFunction<BigDecimal, BigDecimal, BigDecimal> function;

    Operator(char symbol, int priority, BiFunction<BigDecimal, BigDecimal, BigDecimal> function) {
        this.symbol = symbol;
        this.priority = priority;
        this.function = function;
    }

    public char getSymbol() {
        return symbol;
    }

    public int getPriority() {
        return priority;
    }

    public BiFunction<BigDecimal, BigDecimal, BigDecimal> getFunction() {
        return function;
    }

    public static Operator of(char inputOperator) {
        for (Operator operator : OPERATORS) {
            if (operator.symbol == inputOperator) {
                return operator;
            }
        }
        throw new IllegalArgumentException("유효하지 않은 연산자입니다.");
    }
}
