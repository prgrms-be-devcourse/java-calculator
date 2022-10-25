package com.programmers.java.engin;

import com.programmers.java.engin.io.Calculation;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.function.Consumer;

public class postfixCalculation implements Calculation {
    DecimalFormat df = new DecimalFormat("#.##");

    @Override
    public String getResult(String expression) {
        List<String> postfix = toPostfix(expression);
        return calculate(postfix);
    }

    private List<String> toPostfix(String expression) {
        // 유효성 체크
        /*
         ver 1
        1. () 연산자는 없다고 가정
        2. 연산자와 숫자 사이 공백이 있는 형태의 input이 들어온다는 가정
        3. 나눗셈 소수점 자리 버림
        4. 피연산자로 음수 안됌
        * */
        Stack<String> stack = new Stack<>();
        List<String> postfix = new ArrayList<>();
        for (String s : expression.split(" ")){
            if (s.matches("^[0-9]*$")){
                postfix.add(s);
            }else{
                if (stack.isEmpty()){
                    stack.push(s);
                } else {
                    String popped = stack.pop();
                    if (getPriority(s)>getPriority(popped)){
                        postfix.add(popped);
                    }else{
                        stack.push(popped);
                    }
                    stack.push(s);
                }
            }
        }
        while(!stack.isEmpty()){
            postfix.add(stack.pop());
        }
        return postfix;
    }

    private int getPriority(String s) {
        if (s.equals("*") || s.equals("/")) return 1;
        else return 2;
    }

    private String calculate(List<String> list) {
        Stack<Double> stack = new Stack<>();
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String data) {
                if (data.matches("^[0-9]*$")) {
                    stack.push(Double.parseDouble(data));
                } else {
                    double num1 = stack.pop();
                    double num2 = stack.pop();
                    double temp;

                    if (data.equals("+")) temp = num2 + num1;
                    else if (data.equals("-")) temp = num2 - num1;
                    else if (data.equals("*")) temp = num2 * num1;
                    else {
                        if (num2*num1 != 0 ) {
                            temp = num2 / num1;
                            temp = Math.round(temp * 1000) / 1000.0;
                        }else{
                            return;
                        }
                    }
                    stack.push(temp);
                }
            }
        });


        return df.format(stack.pop());
    }

}
