package validation;

import java.util.Stack;

public class Validator {
    private static final String numberPattern = "^[0-9]";
    private static final String operatorPattern = "^[-+*/]";
    private static final String exprSequence = "^([0-9][-+*/])+[0-9]$";

    public static boolean isNumber(String getString) {
        return getString.matches(numberPattern);
    }

    public static boolean isNotNumber(String getString) {
        return !isNumber(getString);
    }

    public static boolean isOperator(String getString) {
        return getString.matches(operatorPattern);
    }

    public static boolean isOpenBrackets(String getString) {
        return getString.equals("(");
    }

    public static boolean isCloseBrackets(String getString) {
        return getString.equals(")");
    }

    public static boolean checkBrackets(String getExpr) {
        Stack<String> bracketStack = new Stack<>();
        String[] exprArray = getExpr.split("");

        for (String elem : exprArray) {
            if (isOpenBrackets(elem)) {
                bracketStack.push(elem);
            } else if (isCloseBrackets(elem)) {
                if (bracketStack.isEmpty()) {
                    return false;
                }
                bracketStack.pop();
            }
        }
        return bracketStack.isEmpty();
    }

    public static boolean exprSequenceCheck(String getExpr) {
        getExpr = getExpr.replace("(", "").replace(")", "");
        return getExpr.matches(exprSequence);
    }

    public static boolean isRightExpr(String getExpr) {
        return checkBrackets(getExpr) && exprSequenceCheck(getExpr);
    }
}
