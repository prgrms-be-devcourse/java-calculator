package com.programmers.java.util;

import java.util.regex.*;
import java.util.List;
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