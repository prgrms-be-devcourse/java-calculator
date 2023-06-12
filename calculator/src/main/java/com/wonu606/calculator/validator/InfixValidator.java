package com.wonu606.calculator.validator;

import com.wonu606.calculator.model.Operator;
import java.util.ArrayList;
import java.util.List;

public class InfixValidator implements Validator {

    private static boolean isExpectedNumericPosition(int position) {
        return position % 2 == 0;
    }

    @Override
    public boolean isValid(String expression) {
        String[] tokens = expression.split("\\s");
        List<String> operators = getOperators();

        for (int i = 0; i < tokens.length; i++) {
            if (isInvalidToken(i, tokens[i], operators)) {
                return false;
            }
        }
        return true;
    }

    private boolean isInvalidToken(int position, String str, List<String> operators) {
        if (isExpectedNumericPosition(position)) {
            return !isNumeric(str);
        }
        return !isOperator(operators, str);
    }

    private List<String> getOperators() {
        List<String> operators = new ArrayList<>();
        for (Operator operator : Operator.values()) {
            operators.add(operator.symbol);
        }
        return operators;
    }

    private Boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private boolean isOperator(List<String> operators, String expectedOperator) {
        return operators.contains(expectedOperator);
    }
}
