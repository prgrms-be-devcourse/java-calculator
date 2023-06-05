package com.devcourse.valid;

import java.util.regex.Pattern;

public class FormulaValidator {

    public static boolean valid(String formula) {
        return Pattern.matches("\\(?\\d+(\\s[+\\-*/]\\s\\(?\\d+\\)?)+", formula);
    }
}
