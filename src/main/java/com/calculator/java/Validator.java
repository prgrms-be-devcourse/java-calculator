package com.calculator.java;

import com.calculator.java.engine.comand.CommandTypes;

import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Validator {
    public final List<String> validCommandIds;

    public Validator(CommandTypes[] commandTypes) {
        this.validCommandIds = Arrays.asList(commandTypes).stream()
                .map(commandType -> commandType.getCommandId())
                .collect(Collectors.toList());
    }

    public boolean validateSelectedCommand(String selectedCommand) {
        if(validCommandIds.contains(selectedCommand)) return true;
        else return false;
    }

    public boolean validateMathExpression(String expression) {
        boolean isValid = !(expression.contains("  ") || expression.length() == 1);

        StringTokenizer st = new StringTokenizer(expression);
        int numbOfElements = st.countTokens();

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
