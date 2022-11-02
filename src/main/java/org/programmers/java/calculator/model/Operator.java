package org.programmers.java.calculator.model;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Operator {
    OPEN_BRACKET('(', 0, 6, (a, b) -> 0.0),
    CLOSE_BRACKET(')', 5, 5, (a, b) -> 0.0),
    PLUS('+', 1, 1, (a, b) -> a + b),
    MINUS('-', 1, 1, (a, b) -> a - b),
    MULTIPLY('*', 2, 2, (a, b) -> a * b),
    DIVIDE('/', 2, 2, (a, b) -> a / b),
    REMAIN('%', 2, 2, (a, b) -> a % b),
    SQUARED('^', 3, 4, (a, b) -> Math.pow((double) a, (double) b)),
    NOT_DEFINED('\u0000', -1, -1, null);

    private int priorityInStack;//스택 안에서의 우선순위
    private int priorityAsInput;//입력으로써의 우선순위
    private char charValue;
    private BinaryOperator<Double> operate;

    public static Operator from(char operator) {
        return Arrays.stream(Operator.values())
                .filter(op -> op.getCharValue() == operator)
                .findAny().orElse(NOT_DEFINED);
    }

    public Double execute(Double i1, Double i2) {
        if ((this.equals(DIVIDE) || this.equals(REMAIN)) && i2 == 0) {
            throw new IllegalStateException("0으로 나눔!");
        }
        return this.operate.apply(i1, i2);
    }

    Operator(char operator, int priorityInStack, int priorityAsInput, BinaryOperator<Double> operate) {
        this.charValue = operator;
        this.priorityInStack = priorityInStack;
        this.priorityAsInput = priorityAsInput;
        this.operate = operate;
    }

    public int getPriorityInStack() {
        return priorityInStack;
    }

    public int getPriorityAsInput() {
        return priorityAsInput;
    }

    public char getCharValue() {
        return charValue;
    }

    public BinaryOperator<Double> getOperate() {
        return operate;
    }
}
