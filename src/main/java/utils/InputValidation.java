package utils;

public class InputValidation {

    private final static String MATH_PROBLEM_PATTERN = "^\\d+(\\s[+\\-*/]\\s\\d+)+$";
    private final static String OPTION_PATTERN = "^(0|1|2)$";

    public static boolean isValidatedMathProblem(String input) {
        if (input.matches(MATH_PROBLEM_PATTERN)) return true;
        return false;
    }

    public static boolean isValidatedOption(String input) {
        if (input.matches(OPTION_PATTERN)) return true;
        return false;
    }
}
