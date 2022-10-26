package com.programmers.calculator.model;

import com.programmers.calculator.domain.OperationResult;

import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Validator {
    public static final String OPERATOR_REGEX = "[\\+\\-\\*/]";
    public static final String NUMBER_REGEX = "^\\d*\\.?\\d*$";

    public static void isRightSpacing(String[] parsedInputStr) {
        if (parsedInputStr.length <= 1 || parsedInputStr.length % 2 == 0) {
            throw new IllegalArgumentException("띄어쓰기가 올바르지 않습니다.");
        }
    }

    public static void isRightOperatorAndNumbers(String[] parsedInputStr) {
        long numericCheck = IntStream.range(0, parsedInputStr.length)
                .filter(i -> i % 2 == 0 && Pattern.matches(NUMBER_REGEX, parsedInputStr[i]))
                .count();
        long operatorCheck = IntStream.range(0, parsedInputStr.length)
                .filter(i -> i % 2 != 0 && Pattern.matches(OPERATOR_REGEX, parsedInputStr[i]))
                .count();

        if (numericCheck + operatorCheck != parsedInputStr.length) {
            throw new IllegalArgumentException("올바른 연산자와 숫자가 아닙니다.");
        }
    }

    public static void isDivisionZero(Optional<OperationResult> operationResult) {
        if (operationResult.equals(Optional.empty())) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
    }
}
