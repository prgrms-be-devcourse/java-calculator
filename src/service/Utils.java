package service;

public class Utils {

    public static boolean isNumberWithWhite(char c) {
        if (isNumber(c))
            return true;
        else if (Character.isWhitespace(c))
            return true;
        return false;
    }

    public static boolean isNumber(char c) {
        return (c >= '0' && c <= '9');
    }

    public static boolean isOperator(char c) {
        return (c == '-' || c == '+' || c == '*' || c == '/');
    }

}
