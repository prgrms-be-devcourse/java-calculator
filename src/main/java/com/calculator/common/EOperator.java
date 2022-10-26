package com.calculator.common;

public enum EOperator {

    ADD('+', 2),
    SUB('-', 2),
    MUL('*', 1),
    DIV('/', 1),
    LEFT('(',3),
    RIGHT(')', 3);

    private final char name;
    private final int priority;

    EOperator(char name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public char getName() {
        return name;
    }

    private int getPriority() {
        return priority;
    }

    public int compare(EOperator e) {
        if (this.getPriority() < e.getPriority()) {
            return -1;
        } else if (this.getPriority() == e.getPriority()) {
            return 0;
        }

        return 1;
    }
}
