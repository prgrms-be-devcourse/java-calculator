package com.calculator.entity;

import lombok.AllArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
public class Expression {
    private String infix;   // 중위 표기법
    private double result;

    public String getInfix() {
        return infix;
    }

    public double getResult() {
        return result;
    }

    @Override
    public String toString() {
        return infix + " = " + result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expression that = (Expression) o;
        return infix.equals(that.infix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(infix);
    }
}
