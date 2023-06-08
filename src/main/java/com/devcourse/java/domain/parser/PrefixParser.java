package com.devcourse.java.domain.parser;

import com.devcourse.java.domain.operator.Operators;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PrefixParser implements ExpressionParser {
    private static final String BLANK = " ";
    public PrefixParser() { }

    @Override
    public List<String> parse(String expression) {
        return toPrefix(expression);
    }

    private List<String> toPrefix(String expression) {
        Deque<String> stack = new ArrayDeque<>();
        List<String> result = new ArrayList<>();

        for (String currentCharacter : expression.split(BLANK)) {
            addOperandAndOrderOperator(stack, result, currentCharacter);
        }

        clearLefts(stack, result);
        return result;
    }

    private void addOperandAndOrderOperator(Deque<String> stack, List<String> result, String currentCharacter) {
        if (isNumber(currentCharacter)) {
            result.add(currentCharacter);
            return;
        }
        addHighPrioritiesToResult(stack, result, currentCharacter);
        stack.push(currentCharacter);
    }

    private void addHighPrioritiesToResult(Deque<String> stack, List<String> result, String currentCharacter) {
        while (isHigherPriority(stack, currentCharacter)) {
            result.add(stack.pop());
        }
    }

    private boolean isHigherPriority(Deque<String> stack, String currentCharacter) {
        return isNotEmpty(stack) && Operators.getPriority(currentCharacter) <= Operators.getPriority(stack.peek());
    }

    private void clearLefts(Deque<String> stack, List<String> result) {
        while (isNotEmpty(stack)) {
            result.add(stack.pop());
        }
    }

    private boolean isNotEmpty(Deque<String> stack) {
        return !stack.isEmpty();
    }

    private boolean isNumber(String currentCharacter) {
        try {
            Integer.parseInt(currentCharacter);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
