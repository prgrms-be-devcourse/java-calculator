package com.devcourse.java.domain.parser;

import com.devcourse.java.domain.operator.Operators;
import com.devcourse.java.domain.validator.Validator;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PrefixParser implements ExpressionParser {
    private static final String BLANK = " ";
    private static Deque<String> stack;

    public PrefixParser() { }

    @Override
    public List<String> parse(String expression, Validator validator) {
        return toPrefix(expression, validator);
    }

    private List<String> toPrefix(String expression, Validator validator) {
        List<String> result = new ArrayList<>();
        initializeStack();

        for (String currentCharacter : expression.split(BLANK)) {
            addOperandAndOrderOperator(result, currentCharacter, validator);
        }

        clearLefts(result);
        return result;
    }

    private void addOperandAndOrderOperator(List<String> result, String currentCharacter, Validator validator) {
        if (validator.isNumber(currentCharacter)) {
            result.add(currentCharacter);
            return;
        }
        addHighPrioritiesToResult(result, currentCharacter);
        stack.push(currentCharacter);
    }

    private void addHighPrioritiesToResult(List<String> result, String currentCharacter) {
        while (isHigherPriority(currentCharacter)) {
            result.add(stack.pop());
        }
    }

    private boolean isHigherPriority(String currentCharacter) {
        return isStackNotEmpty() && Operators.evaluatePriority(currentCharacter) <= Operators.evaluatePriority(stack.peek());
    }

    private void clearLefts(List<String> result) {
        while (isStackNotEmpty()) {
            result.add(stack.pop());
        }
    }

    private boolean isStackNotEmpty() {
        return !stack.isEmpty();
    }

    private void initializeStack() {
        stack = new ArrayDeque<>();
    }
}
