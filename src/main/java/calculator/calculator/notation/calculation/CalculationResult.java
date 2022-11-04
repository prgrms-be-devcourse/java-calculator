package calculator.calculator.notation.calculation;

public class CalculationResult {

    private final String result;

    public CalculationResult(String calculationResult) {
        this.result = calculationResult;
    }

    public String getResult() {
        return result;
    }

    public CalculationResult clone() {
        return new CalculationResult(result);
    }
}
