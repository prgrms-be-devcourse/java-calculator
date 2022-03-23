package com.programmers.java.calculation.parse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidationImpl implements Validation {

    List<String> operator = new ArrayList<>(Arrays.asList("+", "-", "*", "/"));
    List<String> operatorMulAndDiv = new ArrayList<>(Arrays.asList("*", "/"));

    @Override
    public boolean validateContOp(String input) {

        for (int i = 0; i < input.length()-1; i++) {
            if (isContains(operator, input, i) && isContains(operator, input, i + 1)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean validateFirstOp(String input) {
        return !isContains(operatorMulAndDiv, input, 0);
    }

    @Override
    public boolean validateLastOp(String input) {
        return !isContains(operator, input, input.length() - 1);
    }


    @Override
    public boolean validateString(String input) {

        List<String> validChar =
                new ArrayList<>(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "+", "-", "*", "/"));
        for (int i = 0; i < input.length(); i++) {
            if (!isContains(validChar, input, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean isContains(List<String> operator, String input, int index) {
        return operator.contains(String.valueOf(input.charAt(index)));
    }
}
