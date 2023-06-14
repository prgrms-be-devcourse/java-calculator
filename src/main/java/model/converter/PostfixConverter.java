package model.converter;

import constant.Operator;
import model.vo.Expression;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static constant.Operator.*;

public class PostfixConverter implements Converter {
    private static final String WHITESPACE = " ";
    private static final Stack<Operator> operatorStack = new Stack<>();

    @Override
    public List<String> convert(Expression expression) {
        List<String> postfixList = new ArrayList<>();
        String[] nonSpaceExpression = convertToNonSpaceExpression(expression);

        for (String textSegment : nonSpaceExpression) {
            if (isOperator(textSegment)) {
                Operator operator = Operator.findOperator(textSegment);
                processLowPriorityOperators(postfixList, operator);
                operatorStack.push(operator);
                continue;
            }
            postfixList.add(textSegment);
        }
        appendRemainingOperators(postfixList, operatorStack);
        return postfixList;
    }

    private void processLowPriorityOperators(List<String> postfixList, Operator operator) {
        while (!operatorStack.isEmpty() && isHigherPriorityAfterOperator(operatorStack.peek(), operator)) {
            postfixList.add(operatorStack.pop().getSignature());
        }
    }

    private String[] convertToNonSpaceExpression(Expression expression) {
        return expression.getExpression().split(WHITESPACE);
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
