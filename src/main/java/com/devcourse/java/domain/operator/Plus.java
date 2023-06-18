package com.devcourse.java.domain.operator;

public class Plus implements Operator {
    private static Plus INSTANCE;

    private Plus() { }

    public static Plus getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Plus();
        }
        return INSTANCE;
    }

    @Override
    public double operate(double x, double y) {
        return x + y;
    }
}
