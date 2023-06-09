package model;


public class CalculationLog {
    private final String exp;
    private final int result;

    private CalculationLog(final String exp, final int result) {
        this.exp = exp;
        this.result = result;
    }

    public static CalculationLog of(final String exp, final int result) {
        return new CalculationLog(exp, result);
    }

    @Override
    public String toString() {
        return exp + " = " + result;
    }
}
