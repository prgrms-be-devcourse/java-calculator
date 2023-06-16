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

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        CalculationResult that = (CalculationResult) o;
//        return Objects.equals(formula, that.formula) && result == that.result;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(formula, result);
//    }
}
