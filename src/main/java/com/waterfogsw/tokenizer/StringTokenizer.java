package com.waterfogsw.tokenizer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringTokenizer implements Tokenizer {
    private final String regex = "(?<=[^\\d])(?=\\d)|(?=[^\\d])";

    @Override
    public List<String> parse(String exprStr) {
        return Arrays.stream(exprStr.split(regex))
                .filter((token) -> !token.equals(" "))
                .collect(Collectors.toList());
    }
}
