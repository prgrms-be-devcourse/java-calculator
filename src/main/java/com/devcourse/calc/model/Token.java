package com.devcourse.calc.model;

public interface Token {
    boolean isDigit();

    int getProcessedNumber(int... numbers);
}
