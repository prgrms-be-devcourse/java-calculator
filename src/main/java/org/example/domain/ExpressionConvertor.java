package org.example.domain;

import org.example.util.Operator;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ExpressionConvertor {
    public String[] convertToPostfix(String infix) {
        infix = removeSpaces(infix);
        String[] str = splitBySpaces(infix);

        List<String> sb = new ArrayList<>();
        Deque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < str.length; i++) {
            String token = str[i];

            if (isOperand(token)) {
                operandToPostfix(sb, token);
                continue;
            }

            if (isOperator(token)) {
                operatorToPostfix(sb, stack, token);
                continue;
            }

            bracketToPostfix(sb, stack, token);
        }

        while (hasValueInStack(stack)) {
            sb.add(stack.pop());
        }

        String[] result = sb.stream().toArray(String[]::new);
        return result;
    }

    private void bracketToPostfix(List<String> sb, Deque<String> stack, String token) {
        Operator op = Operator.getOperator(token);
        if (op == Operator.OPEN_BRACKET) {
            stack.push(token);
        } else {
            while (hasValueInStack(stack) && !stack.peek().equals("(")) {
                sb.add(stack.pop());
            }
            stack.pop();
        }
    }

    private void operatorToPostfix(List<String> sb, Deque<String> stack, String token) {
        while (hasValueInStack(stack) && shouldPopOperator(stack, token)) {
            sb.add(stack.pop());
        }
        stack.push(token);
        return;
    }

    private void operandToPostfix(List<String> sb, String token) {
        sb.add(token);
        return;
    }

    private boolean isOperator(String token) {
        return Operator.isOperator(token);
    }

    private boolean isOperand(String token) {
        return !Operator.isOperatorOrBracket(token);
    }

    private boolean shouldPopOperator(Deque<String> stack, String token) {
        return getOperatorPriority(stack.peek()) >= getOperatorPriority(token);
    }

    private boolean hasValueInStack(Deque<String> stack) {
        return !stack.isEmpty();
    }

    private String removeSpaces(String infix) {
        infix = infix.replace(" ", "")
                .replace("(", " ( ")
                .replace(")", " ) ")
                .replace("+", " + ")
                .replace("-", " - ")
                .replace("/", " / ")
                .replace("*", " * ")
                .replace("  ", " ")
                .trim();
        return infix;
    }

    private String[] splitBySpaces(String infix) {
        return infix.split(" ");
    }

    private int getOperatorPriority(String operator) {
        return Operator.getOperator(operator).getPriority();
    }
}
