package com.programmers.java.engin.model;

import java.util.*;

public class ConsoleInputExpression implements InputExpression {
    private final String expression;
    private static final int HIGH_PRIORITY = 1;
    private static final int LOW_PRIORITY = 2;
    private static final String NUMBER_FILTER = "^[0-9]*$";

    public ConsoleInputExpression(String input) {
        this.expression = input;
    }

    @Override
    public String getExpression(){
        return expression;
    }

    @Override
    public List<String> getPostfixExpression() {
        Deque<String> tempDeque = new ArrayDeque<>();
        List<String> postfix = new ArrayList<>();
        for (String element : expression.split(" ")){
            if (element.matches(NUMBER_FILTER)){
                postfix.add(element);
            }else{
                if (tempDeque.isEmpty()){
                    tempDeque.push(element);
                } else {
                    String popped = tempDeque.pop();
                    if (getPriority(element)>getPriority(popped)){
                        postfix.add(popped);
                    }else{
                        tempDeque.push(popped);
                    }
                    tempDeque.push(element);
                }
            }
        }
        while(!tempDeque.isEmpty()){
            postfix.add(tempDeque.pop());
        }
        return postfix;
    }

    private int getPriority(String operator) {
        OperatorType operatorType = OperatorType.of(operator);
        if (Objects.equals(operatorType, OperatorType.MULTIPLICATION) ||Objects.equals(operatorType, OperatorType.DIVISION))
            return HIGH_PRIORITY;
        else return LOW_PRIORITY;
    }
}
