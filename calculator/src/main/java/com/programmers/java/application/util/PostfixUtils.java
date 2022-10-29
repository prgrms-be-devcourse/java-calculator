package com.programmers.java.application.util;

import com.programmers.java.engine.model.Expression;

import java.util.*;

import static com.programmers.java.application.config.Constant.ALL_OPERATOR_REGEX;
import static com.programmers.java.application.config.Constant.NUMBER_REGEX;
import static com.programmers.java.application.util.CalculatorUtils.getRank;
import static com.programmers.java.application.util.CalculatorUtils.isMatchRegex;

public class PostfixUtils {
    public Expression makePostfix(Expression expression) {
        List<String> tokens = expression.getTokens();
        Deque<String> deque = new ArrayDeque<>();
        List<String> postfixTokens = new ArrayList<>(tokens.size());

        for (String token : tokens) {
            fillPostfixTokens(deque, postfixTokens, token);
        }

        addRemainOperation(deque, postfixTokens);

        return Expression.builder()
                .tokens(postfixTokens)
                .build();
    }

    private void addRemainOperation(Deque<String> deque, List<String> postfixTokens) {
        while (!deque.isEmpty()) {
            postfixTokens.add(deque.pop());
        }
    }

    private void fillPostfixTokens(Deque<String> deque, List<String> postfixTokens, String token) {
        if (isMatchRegex(token, ALL_OPERATOR_REGEX)) {
            while (!deque.isEmpty() && isOperatorHigherThanPrevOperator(deque, token)) {
                postfixTokens.add(deque.pop());
            }
            deque.push(token);
        } else if (isMatchRegex(token, NUMBER_REGEX)) {
            postfixTokens.add(token);
        }
    }

    private boolean isOperatorHigherThanPrevOperator(Deque<String> deque, String operator) {
        return getRank(operator) <= getRank(deque.peek());
    }
}
