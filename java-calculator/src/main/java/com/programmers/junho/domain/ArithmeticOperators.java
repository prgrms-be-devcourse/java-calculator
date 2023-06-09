package com.programmers.junho.domain;

import java.util.Arrays;

public enum ArithmeticOperators implements Operator{
    ADDITION("+", 0){
        @Override
        public int apply(int a, int b) {
            return a + b;
        }
    },
    SUBTRACTION("-",0){
        @Override
        public int apply(int a, int b) {
            return a - b;
        }
    },
    MULTIPLICATION("*",1){
        @Override
        public int apply(int a, int b) {
            return a * b;
        }
    },
    DIVISION("/",1) {
        @Override
        public int apply(int a, int b) {
            return a / b;
        }
    };

    private final String operator;
    private final int priority;

    ArithmeticOperators(String operator, int priority) {
        this.operator = operator;
        this.priority = priority;

    }

    public static ArithmeticOperators convertTokenToOperator(String token) {
        return Arrays.stream(values())
                .filter(operator -> operator.getOperator().equals(token))
                .findAny()
                .orElseThrow();
    }

    public static boolean isNumber(String token) {
        return Arrays.stream(values())
                .noneMatch(operator -> operator.getOperator().equals(token));
    }

    public String getOperator() {
        return operator;
    }

    public int getPriority() {
        return priority;
    }
}
