package com.programmers.calculation.operation;

import java.util.Arrays;

public enum Operation {
    MULTI("*"),
    DIVISION("/"),
    ADD("+"),
    SUBTRACT("-");

    private final String operation;

    Operation(String operation) {
        this.operation = operation;
    }

    public boolean compare(String oper) {
        return operation.equals(oper);
    }

    public static boolean find(String input) {
        return Arrays.stream(Operation.values())
            .anyMatch(oper -> oper.operation.equals(input));
    }

}
