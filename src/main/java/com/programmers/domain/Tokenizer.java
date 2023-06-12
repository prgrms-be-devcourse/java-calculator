package com.programmers.domain;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
    public List<String> tokenize(String input) {
        List<String> tokens = new ArrayList<>();

        char[] chars = input
                .trim()
                .replaceAll("[ ]+", "")
                .toCharArray();

        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (c >= '0' && c <= '9') {
                sb.append(c);
            } else {
                tokens.add(sb.toString());
                sb.setLength(0);

                tokens.add(String.valueOf(c));
            }
        }
        tokens.add(sb.toString());

        return tokens;
    }
}
