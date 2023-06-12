package io;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorScannerInput implements CalculatorInput {
    private static final String BUTTON_PATTERN = "^[1-2]$";
    private static final String EXPRESSION_PATTERN = "^[0-9]+(\\s[+\\-*/]\\s[0-9]+)+$";
    public static final String INVALID_INPUT_BUTTON = "1 또는 2만 입력 가능합니다.";
    public static final String INVALID_EXPRESSION = "수식이 틀렸습니다.";
    private static final Scanner sc = new Scanner(System.in);

    @Override
    public int inputButton() {
        String input = sc.nextLine();
        if (!validateInput(input, BUTTON_PATTERN)) {
            throw new IllegalArgumentException(INVALID_INPUT_BUTTON);
        }
        return Integer.parseInt(input);
    }

    private boolean validateInput(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        return matcher.matches();
    }

    @Override
    public String inputExpression() {
        String expression = sc.nextLine();
        if (!validateInput(expression, EXPRESSION_PATTERN)) {
            throw new IllegalArgumentException(INVALID_EXPRESSION);
        }
        return expression;
    }
}
