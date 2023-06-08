package view.utils;

public class InputValidation {

    private final static String MATH_EXPRESSION_PATTERN = "^\\d+(\\s[+\\-*/]\\s\\d+)+$";
    private final static String OPTION_PATTERN = "^(1|2)$";

    public static void checkMathExpression(String input) {
        if (!input.matches(MATH_EXPRESSION_PATTERN)) {
            throw new IllegalArgumentException("잘못된 형식입니다.(올바른 예시 : 1 + 2, 1 + 3 * 7)");
        }
    }

    public static void checkOption(String input) {
        if (!input.matches(OPTION_PATTERN)) {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
        }
    }
}