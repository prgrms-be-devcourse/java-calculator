package com.programmers.calculator.core;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Expression {

    private final String expressionString;

    private final Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

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
        validateExpressionRule(Arrays.asList(expressionString.split(" ")));
    }

    private void validateExpressionRule(List<String> expressionSplitList) {
        validateExpressionStartWithNumber(expressionSplitList);
        validateExpressionEndWithNumber(expressionSplitList);
        validateExpressionLengthOdd(expressionSplitList);
        validateExpressionIndex(expressionSplitList);
    }

    private void validateExpressionIndex(List<String> expressionSplitList) {
        for (int i = 0; i < expressionSplitList.size(); i++) {
            validateOperatorIndex(i, expressionSplitList.get(i));
            validateNumberIndex(i, expressionSplitList.get(i));
        }
    }

    private void validateExpressionLengthOdd(List<String> expressionSplitList) {
        if (expressionSplitList.size() % 2 == 0) {
            throw new IllegalArgumentException("식이 잘못되었습니다.");
        }
    }

    private void validateExpressionStartWithNumber(List<String> expressionSplitList) {
        if (!isNumber(expressionSplitList.get(0))) {
            throw new IllegalArgumentException("첫 번째 인덱스의 피연산자가 숫자가 아닙니다");
        }
    }

    private void validateExpressionEndWithNumber(List<String> expressionSplitList) {
        if (!isNumber(expressionSplitList.get(expressionSplitList.size() - 1))) {
            throw new IllegalArgumentException("마지막 인덱스의 피연산자가 숫자가 아닙니다");
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
        return pattern.matcher(value).matches();
    }

    private void validateBlack(String expressionString) {
        if (expressionString.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }
    }

}
