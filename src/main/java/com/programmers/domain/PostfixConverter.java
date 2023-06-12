package com.programmers.domain;

import com.programmers.util.Arithmetic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.function.Supplier;

public class PostfixConverter {
    private List<String> postfixExpression;
    private Stack<String> operators;

    public List<String> convert(List<String> tokenized) {
        postfixExpression = new ArrayList<>();
        operators = new Stack<>();

        for (String token : tokenized) {
            if (Arithmetic.isNumber(token)) {
                postfixExpression.add(token);
            } else {
                popAndAddOperatorsToExpression(() -> getPriority(token) > getPriority(operators.peek()));
                operators.push(token);
            }
        }
        popAndAddOperatorsToExpression(() -> false);

        return postfixExpression;
    }

    private void popAndAddOperatorsToExpression(Supplier<Boolean> breakCondition) {
        while (!operators.isEmpty()) {
            if (breakCondition.get()) {
                break;
            }
            postfixExpression.add(operators.pop());
        }
    }

    private int getPriority(String operator) {
        return switch (operator) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            default -> 0;
        };
    }

}
