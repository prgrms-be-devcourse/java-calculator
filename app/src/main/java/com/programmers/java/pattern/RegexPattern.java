package com.programmers.java.pattern;

public enum RegexPattern {
    NUMBER("[0-9]+([.]{1}[0-9]+)*"),
    OPERATOR("[+\\-*/]+"),
    PARENTHESES("[()]*"),
    MATH_EXPRESSION("^(" + PARENTHESES.pattern + "(" + NUMBER.pattern + ")+" + PARENTHESES.pattern + ")+" +
            "(" + OPERATOR.pattern + PARENTHESES.pattern + "(" + NUMBER.pattern + ")+" + PARENTHESES.pattern + ")*" +
            "(" + OPERATOR.pattern + PARENTHESES.pattern + "(" + NUMBER.pattern + ")+" + PARENTHESES.pattern + ")+$"
    );

    private final String pattern;

    RegexPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }
}

