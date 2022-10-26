package com.programmers.calculator.domain;

public class OperationResult {

    long id;
    String formula;
    String result;

    public long getId() {
        return id;
    }

    public String getFormula() {
        return formula;
    }

    public String getResult() {
        return result;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return  formula + " = " + result;
    }

}
