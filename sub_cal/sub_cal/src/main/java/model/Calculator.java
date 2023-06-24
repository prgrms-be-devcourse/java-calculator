package model;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Stack;
import java.util.StringTokenizer;

public class Calculator {
    private Stack<Double> numberStack = new Stack<>();
    private Stack<String> operStack = new Stack<>();
    private static final int CONVERT_TO_NEGATIVE = -1;

    public String calculate(String expression) {

        String result = operate(expression);

        return result;
    }

    public String operate(String expression) {

        StringTokenizer st = new StringTokenizer(expression);

        classifyOperatorAndNumber(st);

        return calculate();
    }
    private void classifyOperatorAndNumber(StringTokenizer st){

        while(st.hasMoreTokens()){
            String word = st.nextToken();
            Operator operator = null;

            switch (operator = Operator.getOperator(word)){
                case MULTIPLY : case DIVIDE:

                    numberStack.push(Double.parseDouble(st.nextToken()));
                    calculateMultiplyOrDivide(operator.toString());
                    break;
                case PLUS : case MINUS:
                    operStack.add(operator.toString());
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
        while(true){
            if(numberStack.size() == 1) break;

            Double num2 = numberStack.pop();
            Double num1 = numberStack.pop();

            numberStack.push(num1 + num2);
        }


        return String.valueOf(new BigDecimal(numberStack.pop()).setScale(1).stripTrailingZeros());
    }

    private void calculateMultiplyOrDivide(String word) {
        Double num2 = numberStack.pop();
        Double num1 = numberStack.pop();

        if(word.equals("MULTIPLY")) numberStack.push(num1*num2);

        else numberStack.push(num1/num2);
    }
}
