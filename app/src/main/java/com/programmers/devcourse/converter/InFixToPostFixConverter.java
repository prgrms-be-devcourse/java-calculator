package com.programmers.devcourse.converter;

import com.programmers.devcourse.calculator.Operator;
import com.programmers.devcourse.validation.Validator;

import java.util.*;
import java.util.stream.Collectors;

public class InFixToPostFixConverter implements ExpressionConverter {
    private Deque<Character> stack = new ArrayDeque<>();
    private List<String> postfixList = new ArrayList<>();

    private Map<String, Operator> operators = new HashMap<>();
    private Validator validator;

    public InFixToPostFixConverter() {
        for (Operator value : Operator.values()) {
            operators.put(value.operatorStr, value);
        }
        this.validator = Validator.getInstance();
    }

    @Override
    public void convert(String input) {
        input = input.replaceAll("\\s", "");
        StringBuilder tempBuilder = new StringBuilder();

        for (int i = 0; i < input.length(); ++i) {
            if (validator.isNumber(input.charAt(i))) {
                tempBuilder.append(input.charAt(i));

                while ((i + 1) != input.length() && validator.isNumber(input.charAt(i + 1))) {
                    tempBuilder.append(input.charAt(++i));
                }

                postfixList.add(tempBuilder.toString());
                tempBuilder.delete(0, tempBuilder.length());
            } else {
                pushToStack(input.charAt(i));
            }
        }
        stack.clear();
    }

    private void pushToStack(char input) {
        if (stack.isEmpty() || input == '(') {
            stack.addLast(input);
        } else {
            if (input == ')') {
                while (!stack.getLast().equals('(')) {
                    postfixList.add(stack.removeLast().toString());
                }
                stack.removeLast();
            } else {
                if (stack.getLast().equals('(')) {
                    stack.addLast(input);
                } else {
                    while (!stack.isEmpty() && !stack.getLast().equals('(')
                            && operators.get(String.valueOf(input)).precedence <= operators.get(stack.getLast().toString()).precedence) {

                        postfixList.add(stack.removeLast().toString());
                    }
                    stack.addLast(input);
                }
            }
        }

    }


    public List<String> getPostfixList() {
        return postfixList;
    }

    public void clearPostfixList() {
        postfixList.clear();
    }

    public void printPostfixList() {
        for (String postFix : postfixList) {
            System.out.print(postFix + " ");
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "InFixToPostFixConverter{" +
                "postfixList=" + String.join(" ", this.postfixList) +
                '}';
    }
}
