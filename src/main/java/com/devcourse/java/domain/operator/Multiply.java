package com.devcourse.java.domain.operator;

public class Multiply implements Operator {
    private static Multiply INSTANCE;

    private Multiply() { }

    public static Multiply getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Multiply();
        }
        return INSTANCE;
    }

    @Override
    public double operate(double x, double y) {
        return x * y;
    }
}
