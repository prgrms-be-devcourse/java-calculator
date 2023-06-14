package com.programmers.calculator.domain;

import com.programmers.calculator.util.Regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class Expression {
    public List<String> parseToTokens(String inputExpression) {
        List<String> tokens = new ArrayList<>();
        Matcher matcher = Regex.pattern.matcher(inputExpression);

        while (matcher.find()) {
            tokens.add(matcher.group());
        }

        return tokens;
    }
}
