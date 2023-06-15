package com.programmers.calculator.domain.component;

import com.programmers.calculator.constant.Regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class RegexParser implements Parser {
    public List<String> parseToTokens(String expression) {
        List<String> tokens = new ArrayList<>();
        Matcher matcher = Regex.pattern.matcher(expression);

        while (matcher.find()) {
            tokens.add(matcher.group());
        }

        return tokens;
    }
}
