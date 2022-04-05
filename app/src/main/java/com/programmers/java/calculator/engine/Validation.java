package com.programmers.java.calculator.engine;

import com.programmers.java.calculator.engine.model.Arithmetic;
import com.programmers.java.calculator.engine.utils.RegularExpression;

import java.util.ArrayList;
import java.util.Arrays;

public class Validation {
    public Arithmetic tokenize(String input) {
        if (input == null) return (returnEmptyList());
        String[] splitTokens = input.split("\\s");
        boolean checkNumeric = true;

        for (String splitToken : splitTokens) {
            if (checkNumeric) {
                checkNumeric = false;
                if (!RegularExpression.isNumeric(splitToken)) {
                    return returnEmptyList();
                }
            } else {
                checkNumeric = true;
                if (!RegularExpression.isOperator(splitToken)) {
                    return returnEmptyList();
                }
            }
        }
        if (checkNumeric) returnEmptyList();

        return new Arithmetic(new ArrayList<>(Arrays.asList(splitTokens)));
    }

    private Arithmetic returnEmptyList() {
        return new Arithmetic(new ArrayList<>());
    }
}
