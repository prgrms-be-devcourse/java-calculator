package com.programmers.java.engin.model;

import java.util.Arrays;
import java.util.Objects;

public enum OperatorType {
    ADDITION("+",2){
        @Override
        public double result(double num1, double num2) {
            return num1 + num2;
        }
    },
    SUBTRACTION("-",2){
        @Override
        public double result(double num1, double num2) {
            return num1 - num2;
        }
    },
    MULTIPLICATION("*",1){
        @Override
        public double result(double num1, double num2) {
            return num1 * num2;
        }
    },
    DIVISION("/",1){
        @Override
        public double result(double num1, double num2) {
            return num1/num2;
        }
    };

    private final String textOperator;
    private final int priority;

    OperatorType(final String textOperator, int priority) {
        this.textOperator = textOperator;
        this.priority = priority;
    }

    public static OperatorType of(final String symbol){
        return Arrays.stream(values())
                .filter(operatorType -> operatorType.textOperator.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("잘못된 연산식 입니다."));
    }

    public static Boolean getPriority(String firstElem, String secondElem){
        if (OperatorType.of(firstElem).priority > OperatorType.of(secondElem).priority)
            return true;
        return false;
    }

    public abstract double result(double num1, double num2);

}
