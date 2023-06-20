package com.devcourse.calc.model;

public class History {
    private static final String TO_STRING_TEMPLATE = "%s = %d";

    private final String formula;
    private final int result;

    public History(String formula, int result) {
        this.formula = formula;
        this.result = result;
    }

    @Override
    public String toString() {
        return String.format(TO_STRING_TEMPLATE, formula, result);
    }
}
