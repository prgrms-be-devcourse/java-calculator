package com.programmers.java.engin;

import com.programmers.java.engin.io.Calculation;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

public class postfixCalculation implements Calculation {
    DecimalFormat df = new DecimalFormat("#.##");

    @Override
    public Optional<String> getResult(String expression) {
        List<String> postfix = toPostfix(expression);
        return calculate(postfix);
    }

    private List<String> toPostfix(String expression) {
        /*
         ver 1
        1. () 연산자는 없다고 가정
        2. 연산자와 숫자 사이 공백이 있는 형태의 input이 들어온다는 가정
        3. 피연산자로 음수 안됌
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

    private Optional<String> calculate(List<String> list) {
        Stack<Double> stack = new Stack<>();
        AtomicBoolean flag = new AtomicBoolean(true);
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String data) {
                if (data.matches("^[0-9]*$")) {
                    stack.push(Double.parseDouble(data));
                } else {
                    if (stack.size() < 2){
                        flag.set(false);
                        return;
                    }
                    double num1 = stack.pop();
                    double num2 = stack.pop();
                    double temp;

                    if (data.equals("+")) temp = num2 + num1;
                    else if (data.equals("-")) temp = num2 - num1;
                    else if (data.equals("*")) temp = num2 * num1;
                    else if  (data.equals("/")){
                        if (num2*num1 != 0 ) {
                            temp = num2 / num1;
                            temp = Math.round(temp * 1000) / 1000.0;
                        }else{
                            flag.set(false);
                            return;
                        }
                    }else{
                        flag.set(false);
                        return;
                    }
                    stack.push(temp);
                }
            }
        });

        if (flag.get() == false) return Optional.empty();
        return Optional.of(df.format(stack.pop()));
    }

}
