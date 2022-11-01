package com.programmers.cal.engine.postfix;

import com.programmers.cal.engine.model.OriginalExpression;
import com.programmers.cal.engine.model.PostfixExpression;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostfixManager implements Postfix {

    private int getPriority(String operator) {
        if (operator.equals("+") || operator.equals("-")) return 1;
        else return 2;
    }

    private boolean isBigger(String element, String inStack) {
        int elementPriority = getPriority(element);
        int inStackPriority = getPriority(inStack);
        if (elementPriority <= inStackPriority) return true;
        return false;
    }

    @Override
    public PostfixExpression toPostfix(OriginalExpression tokens) {
        Stack<String> stack = new Stack<>();
        List<String> postfix = new ArrayList<>();

        for (String element : tokens.getOriginalTokens()) {

            if (Character.isDigit(element.charAt(element.length() - 1))) {
                postfix.add(element);
            } else {

                while (!stack.isEmpty() && isBigger(element, stack.peek())) {
                    postfix.add(stack.pop());
                }
                stack.push(element);
            }
        }

        while (!stack.isEmpty()) {
            postfix.add(stack.pop());
        }

        return PostfixExpression.builder()
                .inputExpression(tokens.getInputExpression())
                .postfixTokens(postfix)
                .build();
    }
}
