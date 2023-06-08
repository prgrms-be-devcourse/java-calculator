package com.devcourse.java.domain.operator;

import java.util.Arrays;
import java.util.function.Predicate;

public enum Operators {
    PLUS('+', Priority.LOW),
    MINUS('-', Priority.LOW),
    MULTIPLY('*', Priority.HIGH),
    DIVIDE('/', Priority.HIGH),
    ;

    private static class Priority {
        private static final int HIGH = 2;
        private static final int LOW = 1;
        private static final int OPERAND = 0;
    }

    private final char symbol;
    private final int priority;

    Operators(char symbol, int priority) {
        this.symbol = symbol;
        this.priority = priority;
    }

    public static boolean isOperator(char symbol) {
        return Arrays.stream(Operators.values())
                .anyMatch(isSame(symbol));
    }

    public static int getPriority(char symbol) {
        return Arrays.stream(Operators.values())
                .filter(isSame(symbol))
                .findFirst()
                .map(operator -> operator.priority)
                .orElse(Priority.OPERAND);
    }

    private static Predicate<Operators> isSame(char symbol) {
        return operator -> operator.symbol == symbol;
    }
}
