package calculator.utils;

public class StringUtils {

    private static final String NUMERIC_REGEX = "\\d+";
    private static final String EXPRESSION_REGEX = "^\\d+(\\s[+\\-*/]\\s\\d+)*";
    private static final String EMPTY = " ";

    public static boolean isNumeric(String numericString) {
        return numericString.matches(NUMERIC_REGEX);
    }

    public static boolean isMatchingExpressionRegex(String expression) {
        return expression.matches(EXPRESSION_REGEX);
    }

    public static String[] splitToElements(String expression) {
        return expression.split(EMPTY);
    }
}
