package com.programmers.java.calculation.parse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidationAddDecimalImpl implements Validation {

    List<String> operator = new ArrayList<>(Arrays.asList("+", "-", "*", "/", "."));
    List<String> operatorMulAndDiv = new ArrayList<>(Arrays.asList("*", "/", "."));


    @Override
    public boolean validationTotal(String input) {
        return validateContOp(input) && validateFirstOp(input) && validateLastOp(input) && validateString(input);
    }

    private boolean validateContOp(String input) {

        for (int i = 0; i < input.length()-1; i++) {
            if (isContains(operator, input, i) && isContains(operator, input, i + 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean validateFirstOp(String input) {
        return !isContains(operatorMulAndDiv, input, 0);
    }

    private boolean validateLastOp(String input) {
        return !isContains(operator, input, input.length() - 1);
    }


    private boolean validateString(String input) {

        List<String> validChar =
                new ArrayList<>(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "+", "-", "*", "/", "."));

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
