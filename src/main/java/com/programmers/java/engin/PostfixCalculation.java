package com.programmers.java.engin;

import com.programmers.java.engin.io.Calculation;
import com.programmers.java.engin.model.InputExpression;
import com.programmers.java.engin.model.OperatorType;

import java.text.DecimalFormat;
import java.util.*;


public class PostfixCalculation implements Calculation {
    DecimalFormat resultBuffer = new DecimalFormat("#.##");

    private static final String NUMBER_FILTER = "^[0-9]*$";


    @Override
    public String getResult(InputExpression expression) {
        List<String> postfix = expression.getPostfixExpression();
        return calculate(postfix);
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

                temp = OperatorType.of(element).result(num2,num1);
                tempDeque.push(temp);
            }
        }

        return resultBuffer.format(tempDeque.pop());
    }

}
