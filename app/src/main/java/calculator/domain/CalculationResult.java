package calculator.domain;

public class CalculationResult {
    private String expression;
    private String answer;

    public CalculationResult(String expression, String answer){
        this.expression = expression;
        this.answer = answer;
    }

    public String getExpression(){
        return expression;
    }

    public String getAnswer(){
        return answer;
    }
}
