package com.programmers;

import com.programmers.constant.ErrorMessage;
import com.programmers.exception.InvalidOperatorException;

import java.util.Arrays;

public enum Operator {
    ADD("+", 1),
    SUBTRACT("-", 1),
    MULTIPLY("*", 2),
    DIVIDE("/", 2);

    private final String symbol;
    private final int priority;

    Operator(String symbol, int priority) {
        this.symbol = symbol;
        this.priority = priority;
    }

    public String getSymbol() {
        return symbol;
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
}
