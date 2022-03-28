package com.programmers.java.engine.service;

import com.programmers.java.engine.model.Formula;
import com.programmers.java.engine.service.utils.Function;

import java.util.Optional;
import java.util.StringTokenizer;

public class ValidationService {

    public Optional<Formula> Validation(String inputFormula) {
        StringTokenizer s = new StringTokenizer(inputFormula);
        String str = "";
        if (!s.hasMoreElements())
            return Optional.empty();
        boolean divideCheck = false;
        for (int i = 0; s.hasMoreElements(); i++) {
            str = s.nextToken();
            if (i % 2 == 1) {
                if (!Function.isOperator(str)) {
                    return Optional.empty();
                }
                if (str.equals("/")) {
                    divideCheck = true;
                }
            } else {
                if (!Function.isStrDigit(str)) {
                    return Optional.empty();
                } else if (str.equals("0") && divideCheck) {
                    return Optional.empty();
                }
                divideCheck = false;
            }
        }
        if (!Function.isStrDigit(str))
            return Optional.empty();
        return Optional.of(new Formula(inputFormula.split(" ")));
    }
}
