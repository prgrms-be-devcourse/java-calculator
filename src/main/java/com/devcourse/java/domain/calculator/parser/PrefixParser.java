package com.devcourse.java.domain.calculator.parser;

import com.devcourse.java.domain.operator.Operators;
import com.devcourse.java.common.Validator;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PrefixParser {
    private static final String BLANK = " ";

    public PrefixParser() { }

    public List<String> parse(String expression) {
        return toPrefix(expression);
    }

    private List<String> toPrefix(String expression) {
        Deque<String> stack = new ArrayDeque<>();
        List<String> result = new ArrayList<>();

        for (String character : expression.split(BLANK)) {
            if (isOperator(result, character)) {
                addToResult(stack, result, character);
            }
        }

        clearLeftsToResult(stack, result);
        return result;
    }

    private boolean isOperator(List<String> result, String character) {
        if (Validator.isNumber(character)) {
            result.add(character);
            return false;
        }
        return true;
    }

    private void addToResult(Deque<String> stack, List<String> result, String character) {
        while (Validator.isNotEmpty(stack) && isPeekHigherPriority(stack, character)) {
            result.add(stack.pop());
        }
        stack.push(character);
    }

    private boolean isPeekHigherPriority(Deque<String> stack, String character) {
        return Operators.evaluatePriority(character) <= Operators.evaluatePriority(stack.peek());
    }

    private void clearLeftsToResult(Deque<String> stack, List<String> result) {
        while (Validator.isNotEmpty(stack)) {
            result.add(stack.pop());
        }
    }
}
