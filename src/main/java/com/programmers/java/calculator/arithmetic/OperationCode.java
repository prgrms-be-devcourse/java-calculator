package com.programmers.java.calculator.arithmetic;

import java.util.Map;

public enum OperationCode {
    ADD(1),
    SUB(1),
    MUL(2),
    DIV(2);

    private final int priority;

    private static final Map<String, OperationCode> OPERATION_CODE = Map.of(
            "+", ADD,
            "-", SUB,
            "*", MUL,
            "/", DIV
    );

    OperationCode(int priority) {
        this.priority = priority;
    }

    public static int getPriority(String token){
        return OPERATION_CODE.get(token).priority;
    }

    public static boolean isOperator(String token){
        return OPERATION_CODE.containsKey(token);
    }
}
