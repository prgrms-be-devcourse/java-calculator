package org.example;

import java.util.Optional;
import java.util.Stack;
import java.util.regex.Pattern;


public class Calculator {

    private final Pattern RegexNum = Pattern.compile("[0-9]+");

    public double calculate(String infixExpression) {
        String postfixExpression = toPostfix(infixExpression.split(" "));
        Stack<Double> operandStack = new Stack<>();

        for (String value : postfixExpression.split(" ")) {
            if (isNumber(value)) {
                operandStack.push(Double.parseDouble(value));
                continue;
            }
            double left = operandStack.pop();
            double right = operandStack.pop();
            CalculateType.findBySymbol(value).ifPresentOrElse(calculateType -> {
                double midResult =  calculateType.calculate(left,right);
                operandStack.push(midResult);
            },() -> new NullPointerException());

        }
        double result = operandStack.pop();

        return result;
    }

    private String toPostfix(String[] infixExpression) {
        Stack<String> operatorStack = new Stack<>();
        StringBuilder postfixExpression = new StringBuilder();

        for (String value : infixExpression) {

            if (isNumber(value)) {
                postfixExpression.append(value + " ");
                continue;
            }
            //연산자라면 -> 스택에 담긴 연산자와 우선순위를 비교해 순서대로 넣음
            Optional<CalculateType> calculateType = CalculateType.findBySymbol(value);
            calculateType.ifPresentOrElse(
                    calType -> {
                        while(calType
                        !postfixExpression.isEmpty() && !operatorStack.isEmpty() &&
                                calType.getPriority() < CalculateType.findBySymbol(operatorStack.peek()).getPriority()
                    }

            while () {
                postfixExpression.append(operatorStack.pop() + " ");
            }
            );


            operatorStack.push(value);
        }
        while (!operatorStack.isEmpty()) {
            postfixExpression.append(operatorStack.pop() + " ");
        }
        return postfixExpression.toString();
    }

    private boolean isNumber(String value) {
        if (RegexNum.matcher(value).matches()) {
            return true;
        }
        return false;
    }
}
