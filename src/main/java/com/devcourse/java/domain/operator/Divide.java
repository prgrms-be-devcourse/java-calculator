package com.devcourse.java.domain.operator;

import static com.devcourse.java.common.Errors.DIVIDE_BY_ZERO;

public class Divide implements Operator {
    private static Divide INSTANCE;

    private Divide() { }

    public static Divide getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Divide();
        }
        return INSTANCE;
    }

    @Override
    public double operate(double x, double y) {
        validateDivideByZero(y);
        return x / y;
    }

    public void validateDivideByZero(double denominator) {
        if (denominator == 0) {
            throw new ArithmeticException(DIVIDE_BY_ZERO.toMessage());
        }
    }
}
