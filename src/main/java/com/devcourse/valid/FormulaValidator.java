package com.devcourse.valid;

import java.util.regex.Pattern;

public class FormulaValidator {

    public static boolean valid(String formula) {
        String expressionValidationWithBracket = "\\(?\\d+(\\s[+\\-*/]\\s\\(?\\d+\\)?)+";
        String expressionValidationNoBracket = "\\d+(\\s[+\\-*/]\\s\\d+)+";
        return Pattern.matches(expressionValidationNoBracket, formula);
    }
}
