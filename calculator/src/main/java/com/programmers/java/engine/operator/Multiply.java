package com.programmers.java.engine.operator;

public interface Multiply {
    default double multiply(Double lhs, Double rhs) {
        return lhs*rhs;
    }
}
