package model.converter;

import constant.Operator;
import model.vo.Expression;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostfixConverter implements Converter {
    private static final String WHITESPACE = " ";

    @Override
    public List<String> covert(Expression expression) {
        List<String> postfixList = new ArrayList<>();
        Stack<Operator> operatorStack = new Stack<>();
        String[] noWhitespaceExpression = expression.getExpression().split(WHITESPACE);

        for (String textSegment : noWhitespaceExpression) {
            if (isOperator(textSegment)) {
                Operator operator = Operator.findOperator(textSegment);

                while (!operatorStack.isEmpty() && isHigherPriorityAfterOperator(operatorStack.peek(), operator)) {
                    postfixList.add(operatorStack.pop().getSignature());
                }
                operatorStack.push(operator);
                continue;
            }
            postfixList.add(textSegment);
        }
        appendRemainingOperators(postfixList, operatorStack);
        return postfixList;
    }

    private boolean isOperator(String textSegment) {
        return textSegment.equals(Operator.PLUS.getSignature())
                || textSegment.equals(Operator.MINUS.getSignature())
                || textSegment.equals(Operator.MULTIPLY.getSignature())
                || textSegment.equals(Operator.DIVIDE.getSignature());
    }

    private boolean isHigherPriorityAfterOperator(Operator prev, Operator now) {
        return prev.getPriority() >= now.getPriority();
    }

    private void appendRemainingOperators(List<String> postfixList, Stack<Operator> operatorStack) {
        while (!operatorStack.isEmpty()) {
            postfixList.add(operatorStack.pop().getSignature());
        }
    }
}
