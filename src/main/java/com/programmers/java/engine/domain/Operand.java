package com.programmers.java.engine.domain;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Operand {
    public final Double number;

    public Operand(Double number) {
        this.number = number;
    }
}
