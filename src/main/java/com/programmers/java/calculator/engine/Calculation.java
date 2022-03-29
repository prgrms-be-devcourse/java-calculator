package com.programmers.java.calculator.engine;

import com.programmers.java.calculator.engine.io.Input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Calculation {
    private List<String> operands = new ArrayList<>();

    public Optional<Integer> calculate(String inputString) {
        List<String> parsedString = parse(inputString);
        return Optional.empty();
    }

    private List<String> parse(String inputString) {
        String[] strArr = inputString.split("\\s+");
        List<String> parsedString = new ArrayList<>(Arrays.asList(strArr));
        return null;
    }
}
