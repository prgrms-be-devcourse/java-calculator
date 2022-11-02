package com.programmers.calculator.entity;

public class Operation {

    private final String formula;
    private final String result;

    public Operation(String formula, String result) {
        this.formula = formula;
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    @Override
    public String toString() {
        return  formula + " = " + result;
    }

}
