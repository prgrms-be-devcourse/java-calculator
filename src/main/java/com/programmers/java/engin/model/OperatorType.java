package com.programmers.java.engin.model;

import java.util.Arrays;

public enum OperatorType {
    ADDITION("+"){
        @Override
        public double result(double num1, double num2) {
            return num1 + num2;
        }
    },
    SUBTRACTION("-"){
        @Override
        public double result(double num1, double num2) {
            return num1 - num2;
        }
    },
    MULTIPLICATION("*"){
        @Override
        public double result(double num1, double num2) {
            return num1 * num2;
        }
    },
    DIVISION("/"){
        @Override
        public double result(double num1, double num2) {
            return num1/num2;
        }
    };

    private final String textOperator;

    OperatorType(final String textOperator) {
        this.textOperator = textOperator;
    }

    public static OperatorType of(final String symbol){
        return Arrays.stream(values())
                .filter(operatorType -> operatorType.textOperator.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("잘못된 연산식 입니다."));
    }

    public abstract double result(double num1, double num2);

}
