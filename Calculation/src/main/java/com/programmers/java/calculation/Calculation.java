package com.programmers.java.calculation;

import com.programmers.java.calculation.calculate.Calculate;
import com.programmers.java.calculation.parse.Parsing;
import com.programmers.java.calculation.parse.ParsingImpl;
import com.programmers.java.calculation.parse.Validation;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class Calculation {

    private final Parsing parsing;
    private final Validation validation;
    private final Calculate calculate;

    public Double calculationAndValidate(String input) {
        String result1 = parsing.removeSpase(input);
        boolean validationTotal = validation.validationTotal(input);

        if (validationTotal) {
            List<String> resultList = parsing.makeArray(result1);
            return calculate.cal(resultList);
        } else {
            return null;
        }
    }





}
