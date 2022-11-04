package com.programmers.java.engine.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@Getter
@ToString
public class Equation {
    StringExpression expression;
    Answer answer;

    @Builder
    public Equation(StringExpression expression, Answer answer) {
        this.expression = expression;
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Equation)) return false;
        Equation equation = (Equation) o;
        return Objects.equals(expression.getValue(), equation.expression.getValue()) && Objects.equals(answer.getStringValue(), equation.answer.getStringValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(expression.getValue());
    }
}
