package com.programmers.java;

import com.programmers.java.engine.operations.ArithmeticOperation;

public class OperationImpl implements ArithmeticOperation {
    @Override
    public Double add(Double a, Double b) {
        return a + b;
    }

    @Override
    public Double subtract(Double a, Double b) {
        return a - b;
    }

    @Override
    public Double multiply(Double a, Double b) {
        return a * b;
    }

    @Override
    public Double divide(Double a, Double b) {
        if(b == 0){
            throw new ArithmeticException("0으로 나누는 것은 안됩니다.");
        }
        return a / b;
    }
}
