package com.programmers.java.engine.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class EquationRecord {
    private List<Equation> record;

    @Builder
    public EquationRecord(List<Equation> record) {
        this.record = record;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("\n");

        for (Equation equation : record) {
            stringBuilder.append(equation.getExpression().getValue()).append(" = ");
            stringBuilder.append(equation.getAnswer().getStringValue()).append("\n");
        }

        return stringBuilder.toString();
    }
}
