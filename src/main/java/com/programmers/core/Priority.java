package com.programmers.core;

import java.util.Arrays;
import java.util.Stack;

public enum Priority {
    HIGH(2, new String[]{"/", "*"}), LOW(1, new String[]{"+", "-"});

    private final int priority;
    private final String[] operators;

    Priority(int priority, String[] operators) {
        this.priority = priority;
        this.operators = operators;
    }

    public static int getPriority(String operator) {
        return Arrays.stream(Priority.values())
                .filter(symbol -> Arrays.asList(symbol.operators).contains(operator))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .priority;
    }

    public static boolean isNewOperatorPriorityHigher(String operator, Stack<String> operatorStack) {
        return Priority.getPriority(operatorStack.peek()) < Priority.getPriority(operator);
    }
}

