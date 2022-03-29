package com.programmers.javaCalculator.component;

import com.programmers.javaCalulator.exception.ExceptionMessage;
import com.programmers.javaCalulator.util.Operator;

import java.util.Stack;
import java.util.StringTokenizer;

public class InfixToPostfixConverter implements Converter {

    private String infix;
    private String postfix;

    @Override
    public Converter put(String infix) {
        this.infix = infix;
        return this;
    }

    @Override
    public String convert() {
        validate(infix);
        postfix = makePostfix(infix);
        return postfix;
    }

    /* 후위식으로 변환하기 전에 유효성 검사 */
    private void validate(String infix) {
        String[] target = infix.split(" ");

        /* 식의 최소 조건은 적어도 연산자와 피연산자의 개수의 합이 3개 이상이어야 하며,
        연산자와 피연산자의 개수의 합은 홀수이다. */
        if (target.length < 3 || target.length % 2 == 0) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_ENOUGH_ELEMENTS);
        }

        /* 중위식은 항상 연산자의 좌우로 피연산자가 위치한다. */
        for (int i = 0; i < target.length; i++) {
            if (i % 2 == 0) {
                /* 아래 isOperator()의 파라미터 타입이 문자열이므로 일관성을 유지하기 위해
                isDigit()을 새로 정의한다. */
                if (!isDigit(target[i]))
                    throw new IllegalArgumentException(ExceptionMessage.NOT_DEFINED_OPERAND);
            }
            else {
                if (!Operator.isOperator(target[i]))
                    throw new IllegalArgumentException(ExceptionMessage.NOT_DEFINED_OPERATOR);
            }
        }
    }

    private boolean isDigit(String s) {
        return '0' <= s.charAt(0) && s.charAt(0) <= '9';
    }

    /* 유효성을 검증받은 중위식을 스택을 이용하여 후위식으로 변환한다. */
    private String makePostfix(String infix) {
        StringTokenizer st = new StringTokenizer(infix);
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        while (st.hasMoreTokens()) {
            String token = st.nextToken();

            if(Operator.isOperator(token)) {
                if (stack.isEmpty()) {
                    stack.push(token);
                }
                else {
                    if (Operator.getPrecedence(stack.peek()) > Operator.getPrecedence(token)) {
                        stack.push(token);
                    }
                    else {
                        while(true) {
                            if (stack.isEmpty() ||
                                    Operator.getPrecedence(stack.peek()) > Operator.getPrecedence(token)) {
                                stack.push(token);
                                break;
                            }
                            else {
                                sb.append(stack.pop());
                            }
                        }
                    }
                }
            }
            else {
                sb.append(token);
            }
        }

        while (!stack.isEmpty())
            sb.append(stack.pop());

        return sb.toString();
    }

}
