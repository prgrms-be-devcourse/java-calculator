package com.programmers.java.application.util;

import com.programmers.java.engine.model.Expression;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static com.programmers.java.application.config.Constant.ALL_OPERATOR_REGEX;
import static com.programmers.java.application.config.Constant.NUMBER_REGEX;
import static com.programmers.java.application.util.CalculatorUtils.getRank;
import static com.programmers.java.application.util.CalculatorUtils.isMatchRegex;

public class PostfixUtils {
    public List<String> makePostfix(Expression expression) {
        List<String> tokens = expression.getTokens();
        Stack<String> stack = new Stack<>();
        List<String> postfixTokens = new ArrayList<>(tokens.size());
        int index = 0;

        for (String token : tokens) {
            if (isMatchRegex(token, ALL_OPERATOR_REGEX)) {
                while (!stack.isEmpty() && (getRank(token) <= (getRank(stack.peek())))) {
                    postfixTokens.set(index++, stack.pop());
                }
                stack.push(token);
            } else if (isMatchRegex(token, NUMBER_REGEX)) {
                postfixTokens.set(index++, token);
            }
        }

        while (!stack.isEmpty()) {
            postfixTokens.set(index++, stack.pop());
        }

        return postfixTokens;
    }
}
