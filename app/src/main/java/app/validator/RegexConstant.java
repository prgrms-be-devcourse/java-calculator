package app.validator;

public class RegexConstant {
    public static final String WHITESPACE = "[\\u0020\\u3000\\u200B\\u115F\\u1160\\u3164\\uFFA0\\u2800\\t]";
    public static final String NUMBERS = "\\d+";
    public static final String CORRECT_EXPRESSION = "\\d+||[+\\-*/]";

    private RegexConstant() {}
}
