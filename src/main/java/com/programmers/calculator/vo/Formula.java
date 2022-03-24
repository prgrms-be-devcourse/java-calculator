package com.programmers.calculator.vo;

public class Formula {
    private final String originFormula;
    private final double result;

    public Formula(String originFormula, double result) {
        this.originFormula = originFormula;
        this.result = result;
    }

    @Override
    public String toString() {
        return originFormula + " = " + result;
    }
}
