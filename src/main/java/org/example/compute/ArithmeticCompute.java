package org.example.compute;
import org.example.util.InputStringFormating;
import org.example.util.Operator;

import java.util.*;

public class ArithmeticCompute implements Compute {
    @Override
    public double operate(String input){
        return calculate(prefixToPostfix(input));
    }

    private String[] prefixToPostfix(String input) {
        String[] strArr = InputStringFormating.formating(input);

        List<String> stringBuffer = new ArrayList<>();
        Deque<String> operatorStack = new ArrayDeque<>();

        for (String curStr : strArr) {
            if (Operator.isOperator(curStr)) {
                while (!operatorStack.isEmpty() && isLowerThenStack(curStr, operatorStack.peek())) {
                    stringBuffer.add(operatorStack.pop());
                }
                operatorStack.push(curStr);
            } else stringBuffer.add(curStr);
        }

        while (!operatorStack.isEmpty()){
            stringBuffer.add(operatorStack.pop());
        }

        return stringBuffer.stream()
                .toArray(String[]::new);
    }

    private boolean isLowerThenStack(String str1, String str2) {
        return Operator.compareOperatorPriority(str1, str2);
    }

    public double calculate(String[] input){
        Deque<Double> numStack = new ArrayDeque<>();

        for (String cur : input){
            if (!Operator.isOperator(cur)){
                numStack.push(Double.parseDouble(cur));
            }else {
                Double targetNum1 = numStack.pop();
                Double targetNum2 = numStack.pop();
                Operator curOperator = Operator.getOperator(cur);

                numStack.push(curOperator.calculateByOperator(targetNum2, targetNum1));
            }
        }
        return numStack.pop();
    }

}
