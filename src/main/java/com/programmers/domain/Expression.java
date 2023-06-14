package com.programmers.domain;

import com.programmers.util.Validator;

import java.util.Stack;

public class Expression {
    private final String expression;

    public Expression(String expression) {
        this.expression = expression;
    }

    public static String convertToPostFix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> operatorStack = new Stack<>(); //연산자 저장

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            //연산자인경우
            if (Validator.isOperator(c)) {
                while (!operatorStack.isEmpty() && Validator.hasHigherPrecedence(operatorStack.peek(), c)) {
                    postfix.append(operatorStack.pop());
                }
                operatorStack.push(c);
            }
            //숫자인 경우
            else {
                //숫자를 만나면 바로 postfix에 추가
                postfix.append(c);
            }
        }

        //남은 연산자들 후위 표기법에 추가
        while (!operatorStack.isEmpty()) {
            postfix.append(operatorStack.pop());
        }

        return postfix.toString();
    }
}
