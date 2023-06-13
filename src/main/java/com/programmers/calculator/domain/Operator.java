package com.programmers.calculator.domain;

import com.programmers.calculator.constant.ErrorMessage;
import com.programmers.calculator.exception.InvalidOperatorException;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    ADD("+", 1, Double::sum),
    SUBTRACT("-", 1, (n1, n2) -> n1 - n2),
    MULTIPLY("*", 2, (n1, n2) -> n1 * n2),
    DIVIDE("/", 2, (n1, n2) -> n1 / n2);

    private final String symbol;
    private final int priority;
    private final BiFunction<Double, Double, Double> operation;

    Operator(String symbol, int priority, BiFunction<Double, Double, Double> operation) {
        this.symbol = symbol;
        this.priority = priority;
        this.operation = operation;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getFormattedSymbol() {
        return " " + symbol + " ";
    }

    public static Operator findBySymbol(char symbol) {
        return Arrays.stream(Operator.values())
                .filter(operator -> operator.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new InvalidOperatorException(ErrorMessage.INVALID_OPERATOR));
    }

    public boolean equals(char symbol) {
        return this.symbol.equals(String.valueOf(symbol));
    }

    public boolean isHigherPriorityThan(Operator operator) {
        return this.priority >= operator.priority;
    }

    public double calculate(double operand1, double operand2) {
        return this.operation.apply(operand1, operand2);
    }
}
