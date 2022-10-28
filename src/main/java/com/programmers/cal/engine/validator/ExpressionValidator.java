package com.programmers.cal.engine.validator;

import com.programmers.cal.engine.model.InputData;

import java.util.regex.Pattern;

public class ExpressionValidator implements Validator {

    private static final Pattern pattern = Pattern.compile("^(-?[0-9]+[+\\-*/])+(-?[0-9]+)");

    @Override
    public boolean isExpression(InputData inputdata) {
        String noSpaceExpression = inputdata.getInputString().replaceAll("\\p{Z}", "");
        return pattern.matcher(noSpaceExpression).matches();
    }
}
