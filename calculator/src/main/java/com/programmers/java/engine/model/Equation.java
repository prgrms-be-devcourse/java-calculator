package com.programmers.java.engine.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Equation {
    String expression;
    Answer answer;

    @Builder
    public Equation(String expression, Answer answer) {
        this.expression = expression;
        this.answer = answer;
    }
}
