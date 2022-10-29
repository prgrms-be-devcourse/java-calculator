package calculator.domain;

public class CalculationResultHistory {
    private String expression;
    private String answer;

    public CalculationResultHistory(String expression, String answer) {
        this.expression = expression;
        this.answer = answer;
    }

    public String getExpression() {
        return expression;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return expression + " = " + answer;
    }
}
