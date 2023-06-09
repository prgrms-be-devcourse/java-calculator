package com.devcourse.java.domain.operator;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public enum Operators {
    PLUS("+", Priority.LOW),
    MINUS("-", Priority.LOW),
    MULTIPLY("*", Priority.HIGH),
    DIVIDE("/", Priority.HIGH),
    ;

    private static class Priority {
        private static final int HIGH = 2;
        private static final int LOW = 1;
        private static final int OPERAND = 0;
    }

    private final String symbol;
    private final int priority;

    Operators(String symbol, int priority) {
        this.symbol = symbol;
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public static int evaluatePriority(String symbol) {
        return Arrays.stream(Operators.values())
                .filter(operator -> StringUtils.equals(operator.symbol, symbol))
                .findFirst()
                .map(operator -> operator.priority)
                .orElse(Priority.OPERAND);
    }
}
