package com.programmers.domain;

import com.programmers.exception.ExpressionDividedByZeroException;
import com.programmers.exception.ExpressionEmptyException;
import com.programmers.exception.ExpressionFormatException;
import com.programmers.exception.ExpressionOtherCharacterException;
import com.programmers.util.ExpressionProcessor;

import java.util.List;
import java.util.regex.Pattern;

public class ExpressionValidator {

    private static final String OTHER_PATTERN = "^[+\\-*/\\d]*$";
    private static final String NOT_OPERATOR_PATTERN = "[^+\\-*/]";
    private static final String NOT_NUMBER_PATTERN = "[^0-9]";

    private final ExpressionProcessor expressionProcessor = new ExpressionProcessor();

    public List<String> validate(String expression) {
        validateBeforeSplit(expression);
        List<String> tokens = expressionProcessor.parse(expression);
        validateAfterSplit(tokens);

        return tokens;
    }

    public void validateBeforeSplit(String expression) {
        isEmpty(expression);
        containsOtherCharacter(expression);
    }

    public void validateAfterSplit(List<String> tokens) {
        isEvenNumber(tokens);
        isNotFormat(tokens);
        isDividedByZero(tokens);
    }

    public void isEmpty(String expression) {
        if (expression.isEmpty()) {
            throw new ExpressionEmptyException();
        }
    }

    public void containsOtherCharacter(String expression) {
        if (!Pattern.matches(OTHER_PATTERN, expression)) {
            throw new ExpressionOtherCharacterException();
        }
    }

    public void isEvenNumber(List<String> tokens) {
        if (tokens.size() == 1 || tokens.size() % 2 == 0) {
            throw new ExpressionFormatException();
        }
    }

    public void isNotFormat(List<String> tokens) {
        for (int index = 0; index < tokens.size(); index++) {
            if (!isRightToken(index, tokens)) {
                throw new ExpressionFormatException();
            }
        }
    }

    public boolean isRightToken(int index, List<String> tokens) {
        if (index % 2 == 0) {
            return !Pattern.matches(NOT_NUMBER_PATTERN, tokens.get(index));
        }

        return !Pattern.matches(NOT_OPERATOR_PATTERN, tokens.get(index));
    }

    public void isDividedByZero(List<String> tokens) {
        for (int index = 0; index < tokens.size() - 1; index++) {
            String tokenOne = tokens.get(index);
            String tokenTwo = tokens.get(index + 1);

            if (tokenOne.equals("/") && tokenTwo.equals("0")) {
                throw new ExpressionDividedByZeroException();
            }
        }
    }
}
