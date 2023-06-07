package com.programmers.postfixconverter;

import java.util.ArrayList;
import java.util.Stack;

public class PostfixConverter {
    public String[] convert(String[] tokenized) {
        ArrayList<String> result = new ArrayList<>();

        boolean numberTurn = true;
        Stack<String> operators = new Stack<>();
        for (String token : tokenized) {
            if(isNumber(token) && numberTurn) {
                result.add(token);

                numberTurn = false;
            } else if(isOperator(token) && !numberTurn) {
                while (!operators.isEmpty()) {
                    if(getPriority(token) > getPriority(operators.peek())) {
                        break;
                    }

                    result.add(operators.pop());
                }
                operators.push(token);

                numberTurn = true;
            } else {
                throw new UnsupportedOperationException("올바른 숫자/연산자를 입력해주세요.");
            }
        }

        while(!operators.isEmpty()) {
            result.add(operators.pop());
        }

        return result.toArray(String[]::new);
    }

    private boolean isNumber(String token) {
        return token.matches("[0-9]+");
    }

    private boolean isOperator(String token) {
        return token.matches("[+\\-*/]?");
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
