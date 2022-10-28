package com.programmers.java.engin;

import java.util.Arrays;

public enum Operator {
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

    Operator(final String textOperator) {
        this.textOperator = textOperator;
    }

    public static Operator of(final String symbol){
        return Arrays.stream(values())
                .filter(operator -> operator.textOperator.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("입력 오류 : 잘못된 연산자 혹은 문자가 포함되어 있습니다."));
    }

    public abstract double result(double num1, double num2);

}
