package validation;

import java.util.Stack;

public class Validator {
    private static final String NUMBER_PATTERN = "^[0-9]+";
    private static final String OPERATOR_PATTERN = "^[-+*/]";
    private static final String EXPRESSION_SEQUENCE = "^(([0-9]+[-+*/])+[0-9]+$)|([0-9]+)";

    public static boolean isNumber(String getString) {
        return getString.matches(NUMBER_PATTERN);
    }

    public static boolean isNotNumber(String getString) {
        return !isNumber(getString);
    }

    public static boolean isOperator(String getString) {
        return getString.matches(OPERATOR_PATTERN);
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

    public static boolean expressionSequenceCheck(String getExpression) {
        getExpression = getExpression.replace("(", "").replace(")", "");
        return getExpression.matches(EXPRESSION_SEQUENCE);
    }

    public static boolean isRightExpression(String getExpression) {
        return checkBrackets(getExpression) && expressionSequenceCheck(getExpression);
    }
}
