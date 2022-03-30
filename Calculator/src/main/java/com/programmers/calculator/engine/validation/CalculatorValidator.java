package com.programmers.calculator.engine.validation;

import java.util.Arrays;

public class CalculatorValidator implements Validator{

    @Override
    public boolean validate(String inputString) {
        String regExp = "[+\\-*/]";
        String[] operands = inputString.split(regExp);
        long count = Arrays.stream(operands)
                .map(s -> s.trim())
                .filter(s -> s.matches("-?\\d+"))
                .count();
        if (count != operands.length) return false;
        return true;
    }
}
