package com.programmers.java.calculator.calculate;

import com.programmers.java.repository.ResultRepository;
import com.programmers.java.util.ExpressionTokenizer;

import java.util.List;
import java.util.Stack;

public class Calculator {


    private static ResultRepository resultRepository = new ResultRepository();
    private static ExpressionTokenizer expressionTokenizer = new ExpressionTokenizer();


    //계산의 역할을 한다.
    public double getResult(String expression) {


        List<String> tokenList = expressionTokenizer.expressionSplit(expression);

        Stack<Double> tempStack = new Stack<>();
        int index = 0;

        while (index < tokenList.size()) {
            String token = tokenList.get(index++);
            switch (token) {
                case "+": {
                    int nextOperand = Integer.parseInt(tokenList.get(index++));
                    tempStack.add(tempStack.pop() + nextOperand);
                    break;
                }
                case "-": {
                    int nextOperand = Integer.parseInt(tokenList.get(index++));
                    tempStack.add(tempStack.pop() - nextOperand);
                    break;
                }
                case "/": {
                    int nextOperand = Integer.parseInt(tokenList.get(index++));
                    tempStack.add(tempStack.pop() / nextOperand);
                    break;
                }
                case "*": {
                    int nextOperand = Integer.parseInt(tokenList.get(index++));
                    tempStack.add(tempStack.pop() * nextOperand);
                    break;
                }
                default:
                    tempStack.add(Double.parseDouble(token));
            }
        }

        double result = tempStack.pop();
        resultRepository.save(expression, Double.toString(result));
        return result;
    }
}