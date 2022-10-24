package com.programmers.java.engine.operator;

public interface Plus {
    default double plus(Double lhs, Double rhs) {
        return lhs+rhs;
    }
}
