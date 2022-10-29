package com.programmers.java.engine.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Equation {
    StringExpression expression;
    Answer answer;

    @Builder
    public Equation(StringExpression expression, Answer answer) {
        this.expression = expression;
        this.answer = answer;
    }
}
