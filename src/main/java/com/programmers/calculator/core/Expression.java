package com.programmers.calculator.core;

import java.util.Arrays;
import java.util.List;

public class Expression {

    private final String expressionString;

    public Expression(String expressionString) {
        validate(expressionString);
        this.expressionString = expressionString;
    }

    public List<String> expressionSplitList() {
        return Arrays.asList(expressionString.split(" "));
    }

    public String getExpressionString() {
        return this.expressionString;
    }

    private void validate(String expressionString) {
        validateBlack(expressionString);
        String[] expressionSplitArray = expressionString.split(" ");
        validateExpressionRule(expressionSplitArray);
    }

    private void validateExpressionRule(String[] expressionSplitArray) {
        if (!isNumber(expressionSplitArray[0]) ) {
            throw new IllegalArgumentException("첫 번째 인덱스의 피연산자가 숫자가 아닙니다");
        }

        if (!isNumber(expressionSplitArray[expressionSplitArray.length - 1])) {
            throw new IllegalArgumentException("마지막 인덱스의 피연산자가 숫자가 아닙니다");
        }

        if (expressionSplitArray.length % 2 == 0) {
            throw new IllegalArgumentException("식이 잘못되었습니다.");
        }

        for (int i = 0; i < expressionSplitArray.length; i++) {
            validateOperatorIndex(i, expressionSplitArray[i]);
            validateNumberIndex(i, expressionSplitArray[i]);
        }
    }

    private void validateOperatorIndex(int index, String input) {
        if (index % 2 != 0 && !Operator.isOperator(input)) {
            throw new IllegalArgumentException("식 값이 잘못 되었습니다.");
        }
    }

    private void validateNumberIndex(int index, String input) {
        if (index % 2 == 0 && !isNumber(input)) {
            throw new IllegalArgumentException("식 값이 잘못 되었습니다.");
        }
    }

    private boolean isNumber(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void validateBlack(String expressionString) {
        if (expressionString.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }
    }
}
