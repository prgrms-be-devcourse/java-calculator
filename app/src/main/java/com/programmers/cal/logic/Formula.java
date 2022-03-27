package com.programmers.cal.logic;

public class Formula {

    private final String formula;
    private final double result;

    public Formula(String formula, double result) {
        this.formula = formula;
        this.result = result;
    }

    @Override
    public String toString() {
        return this.formula + " = " + this.result;
    }

}
