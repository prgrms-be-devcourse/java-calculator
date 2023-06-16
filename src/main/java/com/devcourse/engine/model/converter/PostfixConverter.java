package com.devcourse.engine.model.converter;

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
            convertByOperator(exp, postfixExpression, temp);
        }
        takeRemainExpression(postfixExpression, temp);

        return postfixExpression;
    }

    private void convertByOperator(String exp, List<String> postfixExpression, Stack<Operator> temp) {
        if (Operator.isOperator(exp)) {
            Operator operator = Operator.getOperator(exp);

            if (convertByBranket(operator, postfixExpression, temp))
                return;
            convertWithOperandPriority(operator, postfixExpression, temp);

            temp.add(operator);
            return;
        }
        postfixExpression.add(exp);
    }

    private void convertWithOperandPriority(Operator operator, List<String> postfixExpression, Stack<Operator> temp) {
        while (!temp.isEmpty() && temp.peek().getOperatorPriority() >= operator.getOperatorPriority()) {
            postfixExpression.add(temp.pop().getOperatorString());
        }
    }

    private boolean convertByBranket(Operator operator, List<String> postfixExpression, Stack<Operator> temp) {
        if (operator.getOperatorString().equals("(")) {
            temp.push(operator);
            return true;
        } else if (operator.getOperatorString().equals(")")) {
            convertWithBranketPriority(operator, postfixExpression, temp);
            return true;
        }
        return false;
    }

    private void convertWithBranketPriority(Operator operator, List<String> postfixExpression, Stack<Operator> temp) {
        while (!temp.isEmpty() && !temp.peek().getOperatorString().equals("(")) {
            postfixExpression.add(temp.pop().getOperatorString());
        }
        if (!temp.isEmpty()) temp.pop();
    }

    private void takeRemainExpression(List<String> expression, Stack<Operator> stack) {
        while (!stack.isEmpty()) {
            expression.add(stack.pop().getOperatorString());
        }
    }
}
