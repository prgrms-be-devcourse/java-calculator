package com.programmers.java.engine.service;

import com.programmers.java.engine.model.ValidFormula;

import java.util.Optional;
import java.util.StringTokenizer;

public class ValidationService implements Function {

    public Optional<ValidFormula> Validation(String inputFormula) {
        StringTokenizer s = new StringTokenizer(inputFormula);
        String str = "";
        if (!s.hasMoreElements())
            return Optional.empty();
        boolean divideCheck = false;
        for (int i = 0; s.hasMoreElements(); i++) {
            str = s.nextToken();
            if (i % 2 == 1) {
                if (str.length() != 1 || !isOperator(str.charAt(0)))
                    return Optional.empty();
                if (str.equals("/"))
                    divideCheck = true;
            } else {
                for (int j = 0; j < str.length(); j++) {
                    if (str.charAt(0) == '-') {
                        if (str.length() <= 1)
                            return Optional.empty();
                    } else if (!isDigit(str.charAt(j)))
                        return Optional.empty();
                    else if (str.equals("0") && divideCheck)
                        return Optional.empty();
                }
                divideCheck = false;
            }
        }
        if (!isStrDigit(str))
            return Optional.empty();
        return Optional.of(new ValidFormula(inputFormula.split(" ")));
    }
}
