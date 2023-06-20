package com.programmers.calculator.domain.core;

import com.programmers.calculator.domain.vo.CalculationResult;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.function.BiFunction;

public enum Operator {
    ADDITION('+', 10, CalculationResult::add),
    SUBTRACTION('-', 10, CalculationResult::subtract),
    MULTIPLICATION('*', 100, CalculationResult::multiply),
    DIVISION('/', 100, (o1, o2) -> {
        if (Objects.equals(o2.getValue(), BigDecimal.ZERO)) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return o1.divide(o2);
    });

    private static final Operator[] OPERATORS = Operator.values();

    private final char symbol;
    private final int priority;
    private final BiFunction<CalculationResult, CalculationResult, CalculationResult> function;

    Operator(char symbol, int priority, BiFunction<CalculationResult, CalculationResult, CalculationResult> function) {
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

    public BiFunction<CalculationResult, CalculationResult, CalculationResult> getFunction() {
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
