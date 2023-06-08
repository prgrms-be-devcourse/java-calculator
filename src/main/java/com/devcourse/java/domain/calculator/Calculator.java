package com.devcourse.java.domain.calculator;

import com.devcourse.java.domain.calculateResult.CalculateResult;

public class Calculator {
    public Calculator() {
    }

    public CalculateResult run(String expression) {
        return new CalculateResult(expression, 1);
    }
}
