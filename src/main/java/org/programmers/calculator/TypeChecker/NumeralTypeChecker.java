package org.programmers.calculator.TypeChecker;

import org.programmers.calculator.TypeChecker.TypeChecker;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class NumeralTypeChecker implements TypeChecker {
    private final String digitPattern = "[+-]?[0-9]+$";
    private final String fractionalValuePattern = "[+-]?[0-9]+\\.[0-9]+$";
    private final String[] operatorPatterns = {"\\+", "-", "\\*", "/"};
    private final Map<String, Integer> operatorRank = new HashMap<>();

    public NumeralTypeChecker() {
        setOperatorRank();
    }

    private void setOperatorRank() {
        operatorRank.put("(", 1);
        operatorRank.put(")", 1);
        operatorRank.put("+", 2);
        operatorRank.put("-", 2);
        operatorRank.put("*", 3);
        operatorRank.put("/", 3);
    }

    @Override
    public boolean isOperand(String value) {
        if (Pattern.matches(digitPattern, value)) {
            return true;
        }
        if (Pattern.matches(fractionalValuePattern, value)) {
            return true;
        }
        return false;
    }

    public boolean isFractional(String value) {
        if (Pattern.matches(fractionalValuePattern, value)) {
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

    public boolean isZero(String value) {
        if (value.equals("0") || Pattern.matches("^0\\.0+$", value)) {
            return true;
        }
        return false;
    }

    @Override
    public Map<String, Integer> getOperatorRank() {
        return operatorRank;
    }
}
