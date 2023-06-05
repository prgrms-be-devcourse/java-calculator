package com.devcourse.calc.model;

public class History {
    private static final String TO_STRING_TEMPLATE = "%s = %s";

    private final String formula;
    private final String result;

    public History(String formula, String result) {
        this.formula = formula;
        this.result = result;
    }

    @Override
    public String toString() {
        return String.format(TO_STRING_TEMPLATE, formula, result);
    }
}
