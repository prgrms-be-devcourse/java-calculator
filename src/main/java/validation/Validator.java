package validation;

public class Validator {
    private static final String numberPattern = "^[0-9]";
    private static final String operatorPattern = "^[-+*/]";

    public static boolean isNumber(String getString) {
        return getString.matches(numberPattern);
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
}
