package utils;

public class InputValidation {

    private final static String MATH_PROBLEM_PATTERN = "^\\d+(\\s[+\\-*/]\\s\\d+)+$";
    private final static String OPTION_PATTERN = "^(0|1|2)$";

    private InputValidation() {}

    public static boolean isValidatedMathProblem(String input) {
        return input.matches(MATH_PROBLEM_PATTERN);
    }

    public static boolean isValidatedOption(String input) {
        return input.matches(OPTION_PATTERN);
    }
}
