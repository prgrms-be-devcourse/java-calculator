package com.programmers.domain;

import java.util.ArrayList;

public class Tokenizer {
    public String[] tokenize(String input) {
        ArrayList<String> result = new ArrayList<>();

        char[] chars = input
                .trim()
                .replaceAll("[ ]+", "")
                .toCharArray();

        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (c >= '0' && c <= '9') {
                sb.append(c);
            } else {
                result.add(sb.toString());
                sb.setLength(0);

                result.add(String.valueOf(c));
            }
        }
        result.add(sb.toString());

        return result.toArray(String[]::new);
    }
}
