package com.programmers.calculator.entity;

public class Operation {

    private String formula;
    private String result;

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
