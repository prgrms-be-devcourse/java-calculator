package com.wonu606.calculator.model;

import com.wonu606.calculator.util.CalculatorMessage;

public enum Operator {
    ADD("+", 2){
        @Override
        public double apply(double a, double b) {
            return a + b;
        }
    },
    SUBTRACT("-", 2) {
        @Override
        public double apply(double a, double b) {
            return a - b;
        }
    },
    MULTIPLY("*", 1) {
        @Override
        public double apply(double a, double b) {
            return a * b;
        }
    },
    DIVIDE("/", 1) {
        @Override
        public double apply(double a, double b) {
            if (b == 0) {
                throw new ArithmeticException(CalculatorMessage.NOT_DIVISIBLE_BY_ZERO.message);
            }
            return a / b;
        }
    };

    public final String symbol;
    public final int precedence;

    Operator(String symbol, int precedence) {
        this.symbol = symbol;
        this.precedence = precedence;
    }

    public abstract double apply(double a, double b);

    public static Operator get(String symbol) {
        for (Operator operator : values()) {
            if (operator.symbol.equals(symbol)) {
                return operator;
            }
        }
        return null;
    }
}
