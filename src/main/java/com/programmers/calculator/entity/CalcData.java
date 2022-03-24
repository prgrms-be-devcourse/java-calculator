package com.programmers.calculator.entity;

public class CalcData {
    private Long id;
    private String calcFormula;
    private Double result;

    public CalcData(Long id, String calcFormula, Double result) {
        this.id = id;
        this.calcFormula = calcFormula;
        this.result = result;
    }

    public Long getId() {
        return id;
    }

    public String getCalcFormula() {
        return calcFormula;
    }

    public Double getResult() {
        return result;
    }
}
