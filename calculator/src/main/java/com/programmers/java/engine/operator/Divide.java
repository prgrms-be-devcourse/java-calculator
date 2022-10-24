package com.programmers.java.engine.operator;

public interface Divide {
    default double divide(Double lhs, Double rhs) {
        return lhs/rhs;
    }
}
