package com.programmers.java.engine.domain;

public interface Operator {
    Operand apply(Operand x, Operand y);
}
