package calculator.module.history;
/**
*
* CalculationHistory 설명
*   계산 이력을 표현한 VO 객체
*
**/
public class CalculationHistory {
    private final String expression;
    private final Double calculationResult;

    public CalculationHistory(String expression,Double result){
        this.expression = expression;
        this.calculationResult = result;
    }

    @Override
    public String toString(){
        return expression + " = " + calculationResult.toString();
    }



}
