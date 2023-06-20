package com.programmers.core.data;

public class CalculationResult {
    private String formula;
    private final long result;

    public CalculationResult(String formula, long result) {
        this.formula = formula;
        this.result = result;
    }

    public long getResult() {
        return result;
    }

    @Override
    public String toString() {
        return formula + " = " + result;
    }
}
