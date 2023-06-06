package com.programmers.calculator;

import java.util.Objects;

public class CalcResult {

    String expression;
    String result;

    public CalcResult(String expression, String result) {
        this.expression = expression;
        this.result = result;
    }

    @Override
    public String toString() {
        return expression + " = " + result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalcResult that = (CalcResult) o;
        return expression.equals(that.expression) && result.equals(that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expression, result);
    }
}
