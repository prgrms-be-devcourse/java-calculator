package com.caculator.util;

import java.util.Arrays;

public enum Priority {
    FIRST(2, "*", "/"), SECOND(1, "+", "-"),;

    private final int priority;
    private final String[] operators;

    Priority(int priority, String... operators) {
        this.operators = operators;
        this.priority = priority;
    }

    public static int getPriority(String s) throws IllegalArgumentException {
        return Arrays.stream(Priority.values())
                .filter(op -> Arrays.asList(op.operators).contains(s))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("s는 연산자가 아닙니다."))
                .priority;
    }
}
