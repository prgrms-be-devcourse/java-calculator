package org.example.calculation;
import org.example.util.Operator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ArithmeticCompute implements Compute {
    @Override
    public double operate(String input){
        return calculate(prefixToPostfix(input));
    }

    public String[] prefixToPostfix(String input) {
        String[] str = InputStringFormating.formating(input);

        List<String> stringBuffer = new ArrayList<>();
        Stack<String> operatorStack = new Stack<>();

        for(int i = 0; i < str.length; i++){
            String cur = str[i];

            if (Operator.isOperator(cur)){
                while (!operatorStack.isEmpty() && isLowerThenStack(cur, operatorStack.peek())){
                        stringBuffer.add(operatorStack.pop());
                    }
                    operatorStack.push(cur);
            }else stringBuffer.add(cur);
        }

        while (!operatorStack.isEmpty()){
            stringBuffer.add(operatorStack.pop());
        }

        return stringBuffer.stream()
                .toArray(String[]::new);
    }

    private boolean isLowerThenStack(String str1, String str2) {
        Operator curOperator = Operator.getOperator(str1);
        Operator peekOperator = Operator.getOperator(str2);
        return peekOperator.getPriority() >= curOperator.getPriority();
    }

    public double calculate(String[] input){
        Stack<Double> stack = new Stack<>();

        for (String cur : input){
            if (!Operator.isOperator(cur)){
                stack.push(Double.parseDouble(cur));
            }else {
                Double targetNum1 = stack.pop();
                Double targetNum2 = stack.pop();
                Operator curOperator = Operator.getOperator(cur);

                stack.push(curOperator.calculateByOperator(targetNum2, targetNum1));
            }
        }
        return stack.pop();
    }

}
