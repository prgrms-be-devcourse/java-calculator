package calculator.module.history;
/**
*
* CalculationHistory 설명
*   계산 이력을 표현한 VO 객체
*
**/
public class CalculationHistory {
    private final String content;

    public CalculationHistory(String expression,Number result){
        this.content = expression + " = " + result.toString();
    }
    @Override
    public String toString(){
        return content;
    }



}
