package calculator.model;

public class CalculationResult {
    private final String expression;
    private final String answer;

    public CalculationResult(String expression, String answer){
        this.expression = expression;
        this.answer = answer;
    }

    @Override
    public String toString() {
        return expression + " = " + answer;
    }
}
