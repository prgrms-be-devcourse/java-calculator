package com.devcourse.valid;

import java.util.regex.Pattern;

public class FormulaValidator {

    public static boolean valid(String formula) {
        String expressionValidation = "\\(?\\d+(\\s[+\\-*/]\\s\\(?\\d+\\)?)+";
        return Pattern.matches(expressionValidation, formula);
    }
}
