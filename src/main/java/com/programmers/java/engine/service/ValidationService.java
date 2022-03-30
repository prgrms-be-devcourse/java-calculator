package com.programmers.java.engine.service;

import com.programmers.java.engine.model.Formula;
import com.programmers.java.engine.service.utils.Function;

import java.util.Optional;

public class ValidationService {

    public Optional<Formula> Validation(String inputFormula) {
        String []s = inputFormula.split(" ");
        if (s.length < 3)
            return Optional.empty();
        boolean divideCheck = false;
        for (int i = 0; i < s.length; i++) {
            if (i % 2 == 1) {
                if (!Function.isOperator(s[i])) {
                    return Optional.empty();
                }
                if (s[i].equals("/")) {
                    divideCheck = true;
                }
            } else {
                if (!Function.isStrDigit(s[i])) {
                    return Optional.empty();
                } else if (s[i].equals("0") && divideCheck) {
                    return Optional.empty();
                }
                divideCheck = false;
            }
        }
        if (!Function.isStrDigit(s[s.length - 1]))
            return Optional.empty();
        return Optional.of(new Formula(s));
    }
}
