package com.programmers.calculator.entity;

public class CalcData {
    private String calcFormula;
    private Double result;

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
