package util;

import exception.IllegalExpressionException;

import java.util.regex.Pattern;

public class CalculatorUtil {
    private static final String pattern = "^\\d+(\\s[+\\-*/]\\s\\d+)*$";

    public static int parseNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 숫자가 아닙니다.");
        }
    }

    public static void checkExpressionByRegex(String expression) {
        if (!Pattern.matches(pattern, expression)) {
            throw new IllegalExpressionException("[ERROR] 잘못된 연산식입니다.");
        }
    }
}
