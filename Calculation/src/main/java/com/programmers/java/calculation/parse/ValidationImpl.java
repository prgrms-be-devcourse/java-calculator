package com.programmers.java.calculation.parse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidationImpl implements Validation{

    public boolean validate(String[] input) {
        List<String> operation = new ArrayList<>(Arrays.asList("+", "-", "*", "/"));

        for (int i = 0; i < input.length - 1; i++) {
            if (operation.contains(input[i]) && operation.contains(input[i+1])) {
                return false;
            }

        }

        return true;
    }
}
