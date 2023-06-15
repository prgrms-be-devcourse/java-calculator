package com.programmers.core.data;

public class CalculationRequest {

    private final String formula;

    public CalculationRequest(String formula) {
        this.formula = formula;
    }

    public String getFormula() {
        return formula;
    }

}
