package com.devcourse.java.domain.operator;

public class Division implements Operator {
    private static final String ZERO_DIVISION_ERROR = "0으로 나눌 수 없습니다.";
    private static Division INSTANCE;

    private Division() { }

    public static Division getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Division();
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
            throw new ArithmeticException(ZERO_DIVISION_ERROR);
        }
    }
}
