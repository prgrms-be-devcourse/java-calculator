package com.waterfogsw.tokenizer;

import java.util.Arrays;
import java.util.List;

public class StringTokenizer implements Tokenizer {
    private final String SPLIT_REGEX = " ";

    @Override
    public List<String> tokenize(String stringFormula) {
        return Arrays.stream(stringFormula.split(SPLIT_REGEX)).toList();
    }
}
