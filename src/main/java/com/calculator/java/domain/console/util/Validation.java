package com.calculator.java.domain.console.util;

import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Validation {
    public boolean validate(String expression) {
        StringTokenizer st = new StringTokenizer(expression);

        int numbOfElements = st.countTokens();
        boolean isValid = true;

        for(int i = 0; i < numbOfElements && isValid; i++ ) {
            String element = st.nextToken();

            if (i % 2 == 0) isValid = isNumber(element);
            else isValid = isOperator(element);
        }

        return isValid;
    }

    private boolean isNumber(String element) {
        try {
            Integer.parseInt(element);
            return true;
        } catch (NumberFormatException numberFormatException) {
            return false;
        }
    }

    private boolean isOperator(String element) {
        List<String> operators = Arrays.asList("+", "-", "*", "/");
        return operators.contains(element);
    }
}
