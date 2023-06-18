package com.devcourse.engine.model.accepter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Accepter {

    private static final String REGEXP = "(?:^\\.[0-9]+)|(?:^[0-9]?\\.[\\s+\\-*/]$)|([0-9]+\\.[0-9]+)|([+\\-*/)(])|([0-9]+)|(s*)";
    private static final Pattern pattern = Pattern.compile(REGEXP);

    public List<String> accept(String userInput) {
        List<String> expressions = new ArrayList<>();
        Matcher matcher = pattern.matcher(userInput);
        while (matcher.find()) {
            String token = matcher.group();
            if (token.isBlank()) {
                continue;
            }
            expressions.add(token);
        }
        return expressions;
    }

}
