package com.devcourse.engine.converter;

import com.devcourse.engine.model.Operator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostfixConverter implements Converter {

    @Override
    public List<String> convert(List<String> expression) {
        List<String> postfixExpression = new ArrayList<>();
        Stack<Operator> temp = new Stack<>();

        for (String exp: expression) {
            if (Operator.isOperator(exp)) {

                Operator operator = Operator.getOperator(exp);

                if (operator.getOperatorString().equals("(")) {

                    temp.push(operator);
                    continue;

                } else if (operator.getOperatorString().equals(")")) {

                    while (!temp.isEmpty() && !temp.peek().getOperatorString().equals("(")) {
                        postfixExpression.add(temp.pop().getOperatorString());
                    }

                    if (!temp.isEmpty()) temp.pop();
                    continue;
                }

                while (!temp.isEmpty() && temp.peek().getOperatorPriority() >= operator.getOperatorPriority()) {
                    postfixExpression.add(temp.pop().getOperatorString());
                }

                temp.add(operator);

            } else {
                postfixExpression.add(exp);
            }
        }

        takeRemainExpression(postfixExpression, temp);

        return postfixExpression;
    }

    private void takeRemainExpression(List<String> expression, Stack<Operator> stack) {
        while (!stack.isEmpty()) {
            expression.add(stack.pop().getOperatorString());
        }
    }
}
