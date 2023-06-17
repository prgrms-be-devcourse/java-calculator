package org.example.domain;

import org.example.util.Operator;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class ExpressionConvertor {
    public String[] convertToPostfix(String infix) {
        infix = removeSpaces(infix);
        String[] str = splitBySpaces(infix);

        ArrayList<String> sb = new ArrayList<>();
        Deque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < str.length; i++) {
            String token = str[i];

            if (!Operator.isOperator(token)) {
                sb.add(token);
                continue;
            }

            Operator op = Operator.getOperator(token);

            switch (op) {
                case PLUS:
                case MINUS:
                case MULTIPLY:
                case DIVIDE:
                    while (hasValueInStack(stack) && shouldPopOperator(stack, token)) {
                        sb.add(stack.pop());
                    }
                    stack.push(token);
                    break;
                case OPEN_BRACKET:
                    stack.push(token);
                    break;
                case CLOSE_BRACKET:
                    while (hasValueInStack(stack) && !stack.peek().equals("(")) {
                        sb.add(stack.pop());
                    }
                    stack.pop();
                    break;
                default:
                    throw new RuntimeException("[ERROR] 정상적인 계산식이 아닙니다.");
            }
        }

        while (hasValueInStack(stack)) {
            sb.add(stack.pop());
        }

        String[] result = sb.stream().toArray(String[]::new);
        return result;
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
