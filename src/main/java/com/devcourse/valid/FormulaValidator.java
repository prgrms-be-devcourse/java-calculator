package com.devcourse.valid;

import java.util.regex.Pattern;

public class FormulaValidator {

    private static final String EXPRESSION_NO_BRACKET = "\\d+(\\s[+\\-*/]\\s\\d+)+";

    public static boolean valid(String formula) {
        return Pattern.matches(EXPRESSION_NO_BRACKET, formula);
    }
}
