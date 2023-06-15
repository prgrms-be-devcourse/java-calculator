package org.programmers.converter;

import org.programmers.constant.Operator;
import org.programmers.expression.ExpressionParam;
import org.programmers.expression.ExpressionValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostfixConverter implements Converter{
    private final ExpressionValidator expressionValidator;

    public PostfixConverter() {
        this.expressionValidator = new ExpressionValidator();
    }

    @Override
    public ExpressionParam convert(String expression) {
        StringBuilder number = new StringBuilder();
        List<String> postfix = new ArrayList<>();
        Stack<String> operatorStack = new Stack<>();

        for (String str : expression.split("")) {
            if (expressionValidator.isOperator(str)) {
                addToPostfix(postfix, number.toString());
                number.delete(0, number.length());

                comparePriority(operatorStack, postfix, str);

                operatorStack.push(str);
            } else if (expressionValidator.isNumber(str)) {
                number.append(str);
            } else {
                throw new IllegalArgumentException("잘못된 식입니다.");
            }
        }
        addToPostfix(postfix, number.toString());
        popOperator(operatorStack, postfix);
        return new ExpressionParam(postfix, expression);
    }

    private int getOperatorPriority(String symbol) {
        return Operator.find(symbol).get().getPriority();
    }

    private void comparePriority(Stack<String> operatorStack, List<String> postfix, String symbol) {
        int currentPriority = getOperatorPriority(symbol);

        while (!operatorStack.empty() && (currentPriority >= getOperatorPriority(operatorStack.peek()))) {
            String operator = operatorStack.pop();
            addToPostfix(postfix, operator);
        }
    }

    private void popOperator(Stack<String> operatorStack, List<String> postfix) {
        while (!operatorStack.empty()) {
            addToPostfix(postfix, operatorStack.pop());
        }
    }

    private void addToPostfix(List<String> postfix, String exp) {
        postfix.add(exp);
    }
}
