package com.programmers.java.engine.operator;

public interface Minus {
    default double minus(Double lhs, Double rhs) {
        return lhs-rhs;
    }
}
