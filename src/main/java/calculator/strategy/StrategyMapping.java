package calculator.strategy;

import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@ToString
@NoArgsConstructor
public class StrategyMapping {
    private static Map<String,CalculatorStrategy> calculatorMap = new HashMap<>();

    /**
     * 클래스 초기화 블럭
     * 클래스가 처음 로딩될 때 수행.
     */
    static {
        calculatorMap.put("+",new PlusStrategy());
        calculatorMap.put("-",new MinusStrategy());
        calculatorMap.put("*",new MultiplyStrategy());
        calculatorMap.put("/",new DivideStrategy());
    }

    public CalculatorStrategy getCalculatorStrategy(String operator){
        return calculatorMap.get(operator);
    }



}
