package com.devcourse.java.domain.operator;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public enum OperatorType {
    PLUS("+", Priority.LOW, Plus.getInstance()),
    MINUS("-", Priority.LOW, Minus.getInstance()),
    MULTIPLY("*", Priority.HIGH, Multiply.getInstance()),
    DIVISION("/", Priority.HIGH, Division.getInstance()),
    ;

    private static class Priority {
        private static final int HIGH = 2;
        private static final int LOW = 1;
        private static final int OPERAND = 0;
    }

    private final String symbol;
    private final int priority;
    private final Operator operator;

    OperatorType(String symbol, int priority, Operator operator) {
        this.symbol = symbol;
        this.priority = priority;
        this.operator = operator;
    }

    // for test
    public int getPriority() {
        return priority;
    }

    public String getSymbol() {
        return symbol;
    }

    public Operator getOperator() {
        return operator;
    }

    public static int evaluatePriority(String symbol) {
        return Arrays.stream(OperatorType.values())
                .filter(operator -> StringUtils.equals(operator.symbol, symbol))
                .findFirst()
                .map(operator -> operator.priority)
                .orElse(Priority.OPERAND);
    }
}
