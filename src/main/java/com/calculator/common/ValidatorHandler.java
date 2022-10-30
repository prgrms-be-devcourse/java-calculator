package com.calculator.common;

import java.util.regex.Pattern;

import static com.calculator.common.ExceptionStatus.*;

public class ValidatorHandler {

    private static final String EXPRESSION_PATTERN = "^[+\\-*/()\\d]*$";

    /**
     * input type error
     */
    public int typeError(String type) throws BaseException{
        int size = EType.values().length;
        int t = 0;

        try {
            t = Integer.parseInt(type);

            if (!(1 <= t && t <= size)) {
                throw new BaseException(INPUT_TYPE_ERROR);
            }
        } catch (NumberFormatException e) {
            throw new BaseException(INPUT_TYPE_ERROR);
        }

        return t;
    }

    /**
     * num, operator error
     */
    public void inputError(String input) throws BaseException {
        if (!Pattern.matches(EXPRESSION_PATTERN, input)) {
            throw new BaseException(NOT_NUM_ERROR);
        }
    }
}
