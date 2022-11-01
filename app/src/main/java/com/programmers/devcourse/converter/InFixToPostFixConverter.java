package com.programmers.devcourse.converter;

import com.programmers.devcourse.calculator.Operator;
import com.programmers.devcourse.validation.Validator;

import java.util.*;

public class InFixToPostFixConverter implements ExpressionConverter {
    private final Deque<Character> stack = new ArrayDeque<>();
    private final List<String> postfixList = new ArrayList<>();

    private final Map<String, Operator> operators = new HashMap<>();
    private final Validator validator;

    public InFixToPostFixConverter() {
        for (Operator value : Operator.values()) {
            operators.put(value.getOperatorStr(), value);
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
                            && operators.get(String.valueOf(input)).getPrecedence() <= operators.get(stack.getLast().toString()).getPrecedence()) {

                        postfixList.add(stack.removeLast().toString());
                    }
                    stack.addLast(input);
                }
            }
        }

    }


    @Override
    public List<String> getConvertedList() {
        return postfixList;
    }

    @Override
    public void clearConvertedList() {
        postfixList.clear();
    }


    @Override
    public String toString() {
        return "InFixToPostFixConverter{" +
                "postfixList=" + String.join(" ", this.postfixList) +
                '}';
    }
}
