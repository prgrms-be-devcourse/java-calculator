package com.calculator.entity;

import java.util.Objects;

public class Expression {
    private final static String DELETE_DOT_ZERO = ".0$";

    private String infix;   // 중위 표기법
    private String result;

    public Expression(String infix, String result) {
        this.infix = infix;
        this.result = String.valueOf(result).replaceAll(DELETE_DOT_ZERO, "");
    }

    public String getInfix() {
        return infix;
    }

    public String getResult() {
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
