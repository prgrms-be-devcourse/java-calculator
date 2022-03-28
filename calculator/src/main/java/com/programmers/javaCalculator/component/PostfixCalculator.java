package com.programmers.javaCalculator.component;

import com.programmers.javaCalulator.util.Operator;

import java.util.Stack;

public class PostfixCalculator implements Calculator {

    private Stack<Integer> stack = new Stack<>();

    /* 앞선 InfixToPostfixConverter객체를 통해 유효성을 검증받아 나온 후위식을
    Operator enum class와 스택을 이용하여 계산 후 결과값을 리턴한다. */
    @Override
    public int calculate(String postfix) {
        String[] arr = postfix.split("");

        for (String data : arr) {
            if (Operator.isOperator(data)) {
                Integer first = stack.pop();
                Integer second = stack.pop();
                Integer result = Operator.getResult(data, second, first);
                stack.push(result);
            }
            else {
                stack.push(Integer.valueOf(data));
            }
        }

        return stack.pop();
    }

}
