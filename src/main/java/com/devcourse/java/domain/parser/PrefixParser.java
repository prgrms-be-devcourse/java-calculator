package com.devcourse.java.domain.parser;

import com.devcourse.java.domain.operator.Operators;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PrefixParser implements ExpressionParser {
    public PrefixParser() { }

    @Override
    public List<Character> parse(String expression) {
        return toPrefix(expression);
    }

    private List<Character> toPrefix(String expression) {
        Deque<Character> stack = new ArrayDeque<>();
        List<Character> result = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            char currentCharacter = expression.charAt(i);
            addOperandAndOrderOperator(stack, result, currentCharacter);
        }

        clearLefts(stack, result);
        return result;
    }

    private void addOperandAndOrderOperator(Deque<Character> stack, List<Character> result, char currentCharacter) {
        if (Character.isDigit(currentCharacter)) {
            result.add(currentCharacter);
        } else if (Operators.isOperator(currentCharacter)) {
            addHighPrioritiesToResult(stack, result, currentCharacter);
            stack.push(currentCharacter);
        }
    }

    private void addHighPrioritiesToResult(Deque<Character> stack, List<Character> result, char currentCharacter) {
        while (isHigherPriority(stack, currentCharacter)) {
            result.add(stack.pop());
        }
    }

    private boolean isHigherPriority(Deque<Character> stack, char currentCharacter) {
        return isNotEmpty(stack) && Operators.getPriority(currentCharacter) <= Operators.getPriority(stack.peek());
    }

    private void clearLefts(Deque<Character> stack, List<Character> result) {
        while (isNotEmpty(stack)) {
            result.add(stack.pop());
        }
    }

    private boolean isNotEmpty(Deque<Character> stack) {
        return !stack.isEmpty();
    }
}
