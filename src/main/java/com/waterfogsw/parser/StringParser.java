package com.waterfogsw.parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringParser implements Parser {
    private final String regex = "(?:(?<=[^\\d])(?=\\d)|(?=[^\\d]))";

    @Override
    public List<String> parse(String exprStr) {
        return Arrays.stream(exprStr.split(regex))
                .filter((token) -> !token.equals(" "))
                .collect(Collectors.toList());
    }
}
