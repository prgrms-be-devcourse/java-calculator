package com.programmers.calculator.domain.component;

import com.programmers.calculator.constant.RegexEnum;
import com.programmers.calculator.domain.core.Operator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostfixConverter implements Converter {

    @Override
    public List<String> convert(List<String> tokens) {
        List<String> postfix = new ArrayList<>();
        Stack<Character> operatorStack = new Stack<>();

        for (String token : tokens) {
            if (RegexEnum.isNumeric(token)) {
                postfix.add(token);
                continue;
            }

            compareOperatorPriority(postfix, operatorStack, token.charAt(0));
            operatorStack.push(token.charAt(0));
        }

        pushUntilEmptyStack(postfix, operatorStack);

        return postfix;
    }

    private static void compareOperatorPriority(List<String> postfix, Stack<Character> operatorStack, char tokenChar) {
        while (!operatorStack.isEmpty() && (Operator.of(tokenChar).getPriority() <= Operator.of(operatorStack.peek()).getPriority())) {
            char popOperator = operatorStack.pop();
            postfix.add(String.valueOf(popOperator));
        }
    }

    private static void pushUntilEmptyStack(List<String> postfix, Stack<Character> operatorStack) {
        while (!operatorStack.isEmpty()) {
            postfix.add(operatorStack.pop().toString());
        }
    }

}
