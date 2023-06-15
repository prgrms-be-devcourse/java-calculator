package com.programmers.core.data;

public class CalculationResult {
    private String formula;
    private long result;

    public CalculationResult(String formula, long result) {
        this.formula = formula;
        this.result = result;
    }

    @Override
    public String toString() {
        return formula + " = " + result;
    }

    public long getResult() {
        return result;
    }
}
