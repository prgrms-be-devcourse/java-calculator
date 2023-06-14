package calculator.model.calculator;

public class CalculationResult {
    private final String expression;
    private final Integer answer;
    private static final String CALCULATION_EQUALS_SIGN = " = ";

    public CalculationResult(String expression, Integer answer){
        this.expression = expression;
        this.answer = answer;
    }

    @Override
    public String toString() {
        return expression + CALCULATION_EQUALS_SIGN + answer;
    }
}
