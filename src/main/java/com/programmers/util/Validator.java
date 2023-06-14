package com.programmers.util;

import com.programmers.error.CalculatorException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.programmers.error.ErrorMessage.*;

public class Validator {

    public static int validateMenu(String data) {
        int menuNum = checkInteger(data);
        checkValidMenu(menuNum);
        return menuNum;
    }

    //정수인지 판별
    public static int checkInteger(String data) {
        int num;
        try {
            return num = Integer.parseInt(data);
        } catch (CalculatorException | NumberFormatException e) {
            throw new CalculatorException(NOT_INTEGER_EXCEPTION);
        }
    }

    //1,2,3중 하나의 값을 가지는지 판별
    public static void checkValidMenu(int menuNum) {
        if (!(menuNum >= 1 && menuNum <= 3)) {
            throw new CalculatorException(NOT_MENU_OPTION);
        }
    }

    //식이 숫자와 사칙연산으로 이루어졌는지 확인
    public static void checkValidArithmeticExpression(String expression) {
        String pattern = "^[0-9]+([+\\-*/][0-9]+)*$";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(expression);
        if (!matcher.matches()) throw new CalculatorException(NOT_VALID_ARITHMETIC_EXPRESSION);
    }

    //연산자(+,-,*,/)인지 확인하는 함수
    public static boolean isOperator(String operator) {
        return operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/");
    }

    //정수인지 판별 - boolean 반환
    public static boolean isInteger(String data) {
        Pattern numberPattern = Pattern.compile("^[0-9]*$");
        if (numberPattern.matcher(data).matches()) {
            return true;
        }
        return false;
    }

}
