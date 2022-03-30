package org.programmers.calculator.TypeChecker;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class BooleanTypeChecker implements TypeChecker {
    private final String operandPattern = "^[TF]$";
    private final String[] operatorPatterns = {"\\&", "\\|", "\\!", "->"};
    private final Map<String, Integer> operatorRank = new HashMap<>();

    public BooleanTypeChecker() {
        setOperatorRank();
    }

    private void setOperatorRank() {
        operatorRank.put("->", 2);
        operatorRank.put("&", 2);
        operatorRank.put("|", 2);
        operatorRank.put("!", 3);
    }

    @Override
    public boolean isOperand(String value) {
        if (Pattern.matches(operandPattern, value)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isOperator(String value) {
        for (String operatorPattern : operatorPatterns) {
            if (Pattern.matches(operatorPattern, value)) {
                return true;
            }
        }
        return false;
    }

    public boolean isOperatorWithOneOperand(String value) {
        if (value.equals("!")) {
            return true;
        }
        return false;
    }

    @Override
    public Map<String, Integer> getOperatorRank() {
        return operatorRank;
    }
}
