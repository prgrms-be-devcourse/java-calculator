package com.programmers.validation;

import com.programmers.util.ConstantRegex;

import java.util.ArrayDeque;
import java.util.Deque;

public class Validator {

    private Validator() {
    }

    private static class ValidatorLazyHolder {
        private static final Validator INSTANCE = new Validator();
    }

    public static Validator getInstance() {
        return ValidatorLazyHolder.INSTANCE;
    }

    public void validateInputExpression(String expression) {
        validateParenthesesOrderCorrect(expression);
        validateCorrectExpressionToken(expression);
    }

    private void validateParenthesesOrderCorrect(String expression) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : expression.toCharArray()) {
            fillParenthesesStack(stack, ch);
        }

        if (!stack.isEmpty()) {
            throw new IllegalArgumentException("괄호의 순서가 잘못되었습니다.");
        }
    }

    private void fillParenthesesStack(Deque<Character> stack, char ch) {

        if (ch == ')' && !stack.isEmpty() && stack.peek() == '(') {
            stack.pop();
            return;
        }

        if (ch == '(' || ch == ')') {
            stack.push(ch);
        }
    }

    private void validateCorrectExpressionToken(String expression) {
        expression = expression.replaceAll(ConstantRegex.WHITESPACE_REGEX, "");
        if (!ConstantRegex.EXPRESSION_VALIDATION_REGEX_COMPILE.matcher(expression).matches()) {
            throw new IllegalArgumentException("수식은 숫자와 +, -, *, /, ( , )만 입력이 가능합니다.");
        }
    }


}
