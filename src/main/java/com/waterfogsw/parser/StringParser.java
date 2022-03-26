package com.waterfogsw.parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringParser implements Parser {
    @Override
    public List<String> parse(String exprStr) {
        return Arrays.stream(exprStr.split(" ")).collect(Collectors.toList());
    }
}
