package com.programmers.domain;

import com.programmers.util.Arithmetic;

import java.util.ArrayList;
import java.util.Stack;

public class PostfixConverter {
    public String[] convert(String[] tokenized) {
        ArrayList<String> result = new ArrayList<>();

        Stack<String> operators = new Stack<>();
        for (String token : tokenized) {
            if(Arithmetic.isNumber(token)) {
                result.add(token);
            } else {
                while (!operators.isEmpty()) {
                    if(getPriority(token) > getPriority(operators.peek())) {
                        break;
                    }

                    result.add(operators.pop());
                }
                operators.push(token);
            }
        }

        while(!operators.isEmpty()) {
            result.add(operators.pop());
        }

        return result.toArray(String[]::new);
    }

    private int getPriority(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return 0;
        }
    }

}
