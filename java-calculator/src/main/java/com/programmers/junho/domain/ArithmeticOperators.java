package com.programmers.junho.domain;

public enum ArithmeticOperators implements Operator{
    ADDITION("+"){
        @Override
        public double apply(double a, double b) {
            return a + b;
        }
    },
    SUBTRACTION("-"){
        @Override
        public double apply(double a, double b) {
            return a - b;
        }
    },
    MULTIPLICATION("*"){
        @Override
        public double apply(double a, double b) {
            return a * b;
        }
    },
    DIVISION("/") {
        @Override
        public double apply(double a, double b) {
            return a / b;
        }
    };

    private final String operator;

    ArithmeticOperators(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

}
