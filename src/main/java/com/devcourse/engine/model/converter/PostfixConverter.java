package com.devcourse.engine.model.converter;

import com.devcourse.engine.model.Operator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostfixConverter {

    public List<String> convert(List<String> expressions) {
        List<String> postfixExpressions = new ArrayList<>();
        Stack<Operator> tempStack = new Stack<>();

        for (String expression: expressions) {
            convertByOperator(expression, postfixExpressions, tempStack);
        }
        takeRemainExpression(postfixExpressions, tempStack);

        return postfixExpressions;
    }

    private void convertByOperator(String expression, List<String> postfixExpressions, Stack<Operator> tempStack) {
        if (Operator.isOperator(expression)) {
            Operator operator = Operator.getOperator(expression);

            if (convertByBranket(operator, postfixExpressions, tempStack))
                return;
            convertWithOperandPriority(operator, postfixExpressions, tempStack);

            tempStack.add(operator);
            return;
        }
        postfixExpressions.add(expression);
    }

    private void convertWithOperandPriority(Operator operator, List<String> postfixExpressions, Stack<Operator> tempStack) {
        while (!tempStack.isEmpty() && tempStack.peek().getOperatorPriority() >= operator.getOperatorPriority()) {
            postfixExpressions.add(tempStack.pop().getOperatorString());
        }
    }

    private boolean convertByBranket(Operator operator, List<String> postfixExpressions, Stack<Operator> tempStack) {
        if (operator.getOperatorString().equals("(")) {
            tempStack.push(operator);
            return true;
        } else if (operator.getOperatorString().equals(")")) {
            convertWithBranketPriority(operator, postfixExpressions, tempStack);
            return true;
        }
        return false;
    }

    private void convertWithBranketPriority(Operator operator, List<String> postfixExpressions, Stack<Operator> tempStack) {
        while (!tempStack.isEmpty() && !tempStack.peek().getOperatorString().equals("(")) {
            postfixExpressions.add(tempStack.pop().getOperatorString());
        }
        if (!tempStack.isEmpty()) tempStack.pop();
    }

    private void takeRemainExpression(List<String> expressions, Stack<Operator> stack) {
        while (!stack.isEmpty()) {
            expressions.add(stack.pop().getOperatorString());
        }
    }
}
