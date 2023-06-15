package com.programmers.calculator.constant;

import com.programmers.calculator.domain.vo.Expression;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum RegexEnum {

    FOUR_ARITHMETIC("\\d+|[-+*/]"),
    NUMERIC("\\d+");

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

    public static boolean isNumeric(String token) {
        return token.matches(RegexEnum.NUMERIC.getRegex());
    }

    public static List<String> parseToTokens(Expression expression) {
        List<String> tokens = new ArrayList<>();
        Matcher matcher = RegexEnum.FOUR_ARITHMETIC.getPattern().matcher(expression);

        while (matcher.find()) {
            tokens.add(matcher.group());
        }

        return tokens;
    }
}

