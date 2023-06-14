package com.programmers.java.util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ExpressionTokenizer {
    private static final String EXPRESSION_REGEXP = "\\d+|[-+*/]";

    public List<String> expressionSplit(String expression) {
        Pattern pattern = Pattern.compile(EXPRESSION_REGEXP);
        Matcher matcher = pattern.matcher(expression);

        return matcher.results()
                .map(MatchResult::group)
                .collect(Collectors.toList());
    }
}