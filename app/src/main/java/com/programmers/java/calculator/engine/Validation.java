package com.programmers.java.calculator.engine;

import com.programmers.java.calculator.engine.model.Arithmetic;
import com.programmers.java.calculator.engine.utils.RegularExpression;

import java.util.ArrayList;
import java.util.Arrays;

public class Validation {
    public Arithmetic tokenize(String input) {
        if (input == null) return (getEmptyList());
        String[] splitTokens = input.split("\\s");
        boolean checkNumeric = true;

        for (String splitToken : splitTokens) {
            if (checkNumeric) {
                if (!RegularExpression.isNumeric(splitToken)) {
                    return getEmptyList();
                }
                checkNumeric = false;
            } else {
                if (!RegularExpression.isOperator(splitToken)) {
                    return getEmptyList();
                }
                checkNumeric = true;
            }
        }
        if (checkNumeric) return getEmptyList();

        return new Arithmetic(new ArrayList<>(Arrays.asList(splitTokens)));
    }

    private Arithmetic getEmptyList() {
        return new Arithmetic(new ArrayList<>());
    }
}
