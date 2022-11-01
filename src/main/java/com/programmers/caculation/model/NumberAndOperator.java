package com.programmers.caculation.model;

import java.util.Objects;

public class NumberAndOperator {
    private Double number;
    private Character operator;

    public NumberAndOperator(Double number) {
        this.number = number;
    }

    public NumberAndOperator(Character operator) {
        this.operator = operator;
    }

    public boolean isNumber() {
        return Objects.isNull(this.operator);
    }

    public boolean isOperator() {
        return Objects.isNull(this.number);
    }

    public Character getOperator() {
        return operator;
    }

    public Double getNumber() {
        return number;
    }
}
