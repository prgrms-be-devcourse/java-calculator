package com.programmers.caculation.model;

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
        if (number != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isOperator() {
        if (operator != null) {
            return true;
        } else {
            return false;
        }
    }

    public Character getOperator() {
        return operator;
    }

    public Double getNumber() {
        return number;
    }
}
