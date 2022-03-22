package com.programmers.java.calculation.parse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidationImpl implements ValidationOp, ValidationString {

    List<String> operation = new ArrayList<>(Arrays.asList("+", "-", "*", "/"));

    @Override
    public boolean validate(String[] input) {

        for (int i = 0; i < input.length - 1; i++) {
            if (operation.contains(input[i]) && operation.contains(input[i + 1])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean validateFirstAndLastOp(String[] input) {
        return !operation.contains(input[input.length - 1]);
    }


    @Override
    public boolean validateString(String input) {

        List<String> validChar =
                new ArrayList<>(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "+", "-", "*", "/"));
        for (int i = 0; i < input.length(); i++) {
            if (!(validChar.contains(String.valueOf(input.charAt(i))))) {
                return false;
            }
        }
        return true;
    }
}
