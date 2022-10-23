package com.programmers.java.model;

public class History {
    private String formula;
    private int result;

    public History(String formula, int result) {
        this.formula = formula;
        this.result = result;
    }

    public String getFormula() {
        return formula;
    }

    public int getResult() {
        return result;
    }

    public String getHistory() {
        return formula + "=" + String.valueOf(result);
    }
}
