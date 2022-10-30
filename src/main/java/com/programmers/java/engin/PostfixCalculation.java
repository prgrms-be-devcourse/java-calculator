package com.programmers.java.engin;

import com.programmers.java.engin.io.Calculation;
import com.programmers.java.engin.model.Operator;

import java.text.DecimalFormat;
import java.util.*;


public class PostfixCalculation implements Calculation {
    DecimalFormat resultBuffer = new DecimalFormat("#.##");

    static final String NUMBER_FILTER = "^[0-9]*$";
    static final int HIGH_PRIORITY = 1;
    static final int LOW_PRIORITY = 2;


    @Override
    public String getResult(String expression) {
        List<String> postfix = toPostfix(expression);
        return calculate(postfix);
    }

    private List<String> toPostfix(String expression) {
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

    private int getPriority(String s) {
        if (s.equals("*") || s.equals("/")) return HIGH_PRIORITY;
        else return LOW_PRIORITY;
    }

    private String calculate(List<String> expression) {
        Deque<Double> tempDeque = new ArrayDeque<>();
        for (String element : expression) {
            if (element.matches(NUMBER_FILTER)) {
                tempDeque.push(Double.parseDouble(element));
            } else {
                if(tempDeque.size() < 2){
                    throw new RuntimeException("잘못된 연산식 입니다.");
                }
                double num1 = tempDeque.pop();
                double num2 = tempDeque.pop();
                double temp ;

                temp = Operator.of(element).result(num2,num1);
                tempDeque.push(temp);
            }
        }

        return resultBuffer.format(tempDeque.pop());
    }

}
