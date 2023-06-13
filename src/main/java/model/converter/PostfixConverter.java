package model.converter;

import constant.Operator;
import model.vo.Expression;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostfixConverter implements Converter {

    @Override
    public List<String> covert(Expression expression) {
        List<String> postfixList = new ArrayList<>();
        Stack<Operator> stack = new Stack<>();
        String[] str = expression.getExpression().split(" ");

        for (String s : str) {
            if (isOperator(s)) {
                Operator operator = Operator.findOperator(s);

                while (!stack.isEmpty() && isHigherPriorityAfterOperator(stack.peek(), operator)) {
                    postfixList.add(stack.pop().getSignature());
                }
                stack.push(operator);
                continue;
            }
            postfixList.add(s);
        }
        appendRemainingOperators(postfixList, stack);
        return postfixList;
    }

    private boolean isOperator(String s) {
        return s.equals(Operator.PLUS.getSignature())
                || s.equals(Operator.MINUS.getSignature())
                || s.equals(Operator.MULTIPLY.getSignature())
                || s.equals(Operator.DIVIDE.getSignature());
    }

    private boolean isHigherPriorityAfterOperator(Operator prev, Operator now) {
        return prev.getPriority() >= now.getPriority();
    }

    private void appendRemainingOperators(List<String> postfixList, Stack<Operator> stack) {
        while (!stack.isEmpty()) {
            postfixList.add(stack.pop().getSignature());
        }
    }
}
