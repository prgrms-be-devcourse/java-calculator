package com.programmers.calculator.vo;

public class Formula {
    private final String originFormula;
    private final String result;

    public Formula(String originFormula, String result) {
        this.originFormula = originFormula;
        this.result = result;
    }

    @Override
    public String toString() {
        return originFormula + " = " + result;
    }
}
