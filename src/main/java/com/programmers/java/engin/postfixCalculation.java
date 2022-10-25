package com.programmers.java.engin;

import com.programmers.java.engin.io.Calculation;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.function.Consumer;

public class postfixCalculation implements Calculation {

    @Override
    public int getResult(String expression) {
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

    private int calculate(List<String> list) {
        Stack<Integer> stack = new Stack<>();
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String data) {
                if (data.matches("^[0-9]*$")) {
                    stack.push(Integer.valueOf(data));
                } else {
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    int temp;

                    if (data.equals("+")) temp = num1 + num2;
                    else if (data.equals("-")) temp = num1 - num2;
                    else if (data.equals("*")) temp = num1 * num2;
                    else temp = num1 / num2;

                    stack.push(temp);
                }
            }
        });

        return stack.pop();
    }

}
