package com.programmers.calculator.constant;

import java.util.regex.Pattern;

public enum RegexEnum {

    FOUR_ARITHMETIC("\\d+|[-+*/]");

    private final String regex;
    private final Pattern pattern;

    RegexEnum(String regex) {
        this.regex = regex;
        this.pattern = Pattern.compile(regex);
    }

    public String getRegex() {
        return regex;
    }

    public Pattern getPattern() {
        return pattern;
    }

}

