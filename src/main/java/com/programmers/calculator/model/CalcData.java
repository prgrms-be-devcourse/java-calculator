package com.programmers.calculator.model;

public class CalcData {
    private final String calcFormula;
    private final Double result;

    public CalcData(String calcFormula, Double result) {
        this.calcFormula = calcFormula;
        this.result = result;
    }

    public String getCalcFormula() {
        return calcFormula;
    }

    public Double getResult() {
        return result;
    }
}
