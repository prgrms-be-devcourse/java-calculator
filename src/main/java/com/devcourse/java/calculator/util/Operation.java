package com.devcourse.java.calculator.util;

public enum Operation {

    NOTHING(0),
    PLUS(1),
    MINUS(1),
    MULTIPLY(2),
    DIVIDE(2);

    private final int priority;

    Operation(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return this.priority;
    }

    public static int getOperationPriority(char operation) {
        switch (operation) {
            case '+':
                return PLUS.getPriority();
            case '-':
                return MINUS.getPriority();
            case '*':
                return MULTIPLY.getPriority();
            case '/':
                return DIVIDE.getPriority();
            default:
                return NOTHING.getPriority();
        }
    }
}
