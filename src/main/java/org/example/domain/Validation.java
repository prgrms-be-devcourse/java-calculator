package org.example.domain;

import java.util.regex.Pattern;

public class Validation {

    private final Pattern REGEX_SELECT = Pattern.compile("[12]");
    private final Pattern REGEX_EXPRESSION = Pattern.compile("\\d+(\\s[+\\-*/]\\s\\d+)*");

    public boolean validateExpression(String expression){
        return REGEX_EXPRESSION.matcher(expression).matches();
    }

    public boolean validateSelection(String selection){
        return REGEX_SELECT.matcher(selection).matches();
    }

}
