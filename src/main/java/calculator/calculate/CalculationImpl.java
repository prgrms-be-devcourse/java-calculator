package calculator.calculate;

import calculator.io.Message;
import calculator.strategy.StrategyMapping;
import calculator.validation.Validation;
import calculator.validation.ValidationImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@AllArgsConstructor
@NoArgsConstructor
public class CalculationImpl implements Calculation {
    private StrategyMapping strategyMapping;
    private Validation validation;
    private String formula;

    @Override
    public String calculate(String formula) {
        this.formula = formula;
        validation = new ValidationImpl();
        strategyMapping = new StrategyMapping();
        //Stack<String> elements = new Stack<>();
        List<String> elements = new ArrayList<>();
        // [ *, / ]의 우선순위
        if (MultiplyAndDivide(elements)) {
            return PlusAndMinus(elements);
        }else return Message.CALCULATE_ERROR_MESSAGE.getMessage();

    }

    private String PlusAndMinus(List<String> elements) {
        int countOfElements = elements.size();
        double result = Double.parseDouble(elements.get(0));
        for(int i = 1; i<countOfElements; i += 2){
            String operator = elements.get(i);
            double next = Double.parseDouble(elements.get(i+1));
            result = strategyMapping.getCalculatorStrategy(operator).calculate(result,next);
        }
        return String.valueOf(result);
    }

    private boolean MultiplyAndDivide(List<String> elements) {
        StringTokenizer st = new StringTokenizer(formula);
        int countOfElement = st.countTokens();
        if(countOfElement == 0)return false;

        String firstStr = st.nextToken();
        // 처음 부터 연산자가 들어온 경우.
        if(validation.isOperator(firstStr)) return false;
        elements.add(firstStr);

        for (int i = 1; i < countOfElement; i++) {
            String elementString = st.nextToken();
            int size = elements.size() - 1;
            // 숫자가 입력되어야 하는 상황.
            if(i % 2 == 0) {
                if(validation.isOperator(elementString)) return false;
                String operator = elements.get(size);
                if (operator.equals("*") || operator.equals("/")) {
                    double next = Double.parseDouble(elementString);
                    elements.remove(size);
                    double pre = Double.parseDouble(elements.remove(size-1));
                    // 0을 나누는 경우가 아닌경우
                    if (!validation.divideByZero(operator, next)) return false;
                    // 계산결과
                    elementString = String.valueOf(strategyMapping.getCalculatorStrategy(operator).calculate(pre, next));
                }
                elements.add(elementString);
            }
            else{
                if(!validation.isOperator(elementString)) return false;
                elements.add(elementString);
            }
        }
        return true;
    }

}
