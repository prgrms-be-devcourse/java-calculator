package com.devcourse.java.domain.operator;

public class Minus implements Operator {
    private static Minus INSTANCE;

    private Minus() { }

    public static Minus getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Minus();
        }
        return INSTANCE;
    }

    @Override
    public double operate(double x, double y) {
        return x - y;
    }
}
