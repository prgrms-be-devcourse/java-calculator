package com.bona.javacalculator.util;

import com.bona.javacalculator.io.Console;
import com.bona.javacalculator.core.Operator;


public class Validator {

    private final Console console = new Console();

    public void validateFormula(String input) {
        validateIsEmpty(input);
        validateWithDivideZero(input);
        validateFomat(input);
    }

    private void validateFomat(String input) {
        String[] inputString = input.split("");

        if (inputString.length < 3) {
            throw new RuntimeException("입력식이 포맷에 맞지 않습니다.");
        }
        //마지막 자리가 숫자인지
        if (!isNumber(inputString[inputString.length - 1])) {
            throw new RuntimeException("입력식이 포맷에 맞지 않습니다.");
        }
        for (int i = 0; i < inputString.length; i++) {
            if (i % 2 == 1) { // 홀수 자리일 경우 연산자여야 함.
                if (!Operator.isOperator(inputString[i])) {
                    throw new RuntimeException("입력식이 포맷에 맞지 않습니다.");
                }
            }
        }
    }

    private void validateWithDivideZero(String input) {
        String[] inputString = input.split("");

        boolean isDivision = false;
        for (int i = 0; i < inputString.length; i++) {

            if (i % 2 == 1) {
                if (inputString[i].equals("/")) {
                    isDivision = true;
                }

            } else if (!isValidNumber(inputString[i], isDivision)) {
                throw new RuntimeException("0으로 나눌 수 없습니다.");
            }
        }
    }

    private void validateIsEmpty(String input) {
        if (input.isEmpty()) {
            console.inputError();
            throw new RuntimeException("입력 값이 비어있습니다.");
        }
    }


    private boolean isValidNumber(String split, boolean isDivision) {

        if (!isNumber(split)) {
            return false;
        }

        if (split.equals("0") && isDivision) {
            return false;
        }
        return true;
    }

    public static boolean isNumber(String split) {
        for (int i = 0; i < split.length(); i++) {
            if (!Character.isDigit(split.charAt(i))) {
                return false;
            }
        }
        return true;
    }


    public static boolean isLong(double num) {
        return num == (long) num;
    }

}
