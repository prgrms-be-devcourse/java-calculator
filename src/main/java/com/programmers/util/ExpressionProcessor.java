package com.programmers.util;

import java.util.ArrayList;
import java.util.List;

public class ExpressionProcessor {

    public String removeSpace(String input) {
        return input.trim().replace(" ", "");
    }

    public List<String> parse(String input) {
        List<String> tokens = new ArrayList<>();
        StringBuilder builder = new StringBuilder();

        for (int index = 0; index < input.length(); index++) {
            char number = input.charAt(index);
            if (Character.isDigit(number)) {
                builder.append(number);
                continue;
            }

            addBuilderToTokens(builder, tokens);
            tokens.add(String.valueOf(input.charAt(index)));
        }

        addBuilderToTokens(builder, tokens);

        return tokens;
    }

    public void addBuilderToTokens(StringBuilder builder, List<String> tokens) {
        if (builder.length() != 0) {
            tokens.add(builder.toString());
            builder.setLength(0);
        }
    }
}
