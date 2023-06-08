package com.devcourse.java.domain.operator;

import com.devcourse.java.common.Factory;

public class OperatorFactory implements Factory<Operator, String> {
    public OperatorFactory() { }

    @Override
    public Operator create(String symbol) {
        switch (symbol) {
            case "+":
                return Plus.getInstance();
            case "-":
                return Minus.getInstance();
            case "*":
                return Multiply.getInstance();
            default:
                return Divide.getInstance();
        }
    }
}
