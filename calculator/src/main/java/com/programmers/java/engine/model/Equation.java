package com.programmers.java.engine.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Equation {
    String expression;
    Double answer;

    @Builder
    public Equation(String expression, Double answer) {
        this.expression = expression;
        this.answer = answer;
    }
}
