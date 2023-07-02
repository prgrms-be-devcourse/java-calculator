package model;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Stack;
import java.util.StringTokenizer;

public class Calculator {
    private Stack<Double> numberStack = new Stack<>();
    private Stack<Operator> operStack = new Stack<>();
    private static final int CONVERT_TO_NEGATIVE = -1;

    public String calculate(String expression) {

        String result = operate(expression);

        return result;
    }

    public String operate(String expression) {

        classifyOperatorAndNumber(expression);

        return calculate();
    }
    private void classifyOperatorAndNumber(String expression){
        StringTokenizer st = new StringTokenizer(expression);

        while(st.hasMoreTokens()){
            String word = st.nextToken();
            Operator operator = null;

            switch (operator = Operator.getOperator(word)){
                case MULTIPLY : case DIVIDE:

                    numberStack.push(Double.parseDouble(st.nextToken()));
                    calculateMultiplyOrDivide(operator);
                    break;
                case PLUS : case MINUS:
                    operStack.add(operator);
                    break;
                default:
                    if(operStack.isEmpty() || Operator.isPlus(operStack.pop())){
                        numberStack.push(Double.parseDouble(word));
                        break;
                    }

                    numberStack.push(CONVERT_TO_NEGATIVE *Double.parseDouble(word));
                    break;
            }
        }


    }

    private String calculate(){
        while(numberStack.size() > 1){
            Double num2 = numberStack.pop();
            Double num1 = numberStack.pop();

            numberStack.push(num1 + num2);
        }


        return String.valueOf(new BigDecimal(numberStack.pop()).setScale(1).stripTrailingZeros());
    }

    private void calculateMultiplyOrDivide(Operator operator) {
        Double num2 = numberStack.pop();
        Double num1 = numberStack.pop();

        if(Operator.isMultiply(operator)) numberStack.push(num1*num2);

        else numberStack.push(num1/num2);
    }
}
