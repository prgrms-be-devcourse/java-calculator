package io;

import exception.ExceptionMessage;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CalculatorScannerInput implements CalculatorInput{
    private static final Pattern BUTTON_PATTERN = Pattern.compile("^[1-2]$");
    private static final Pattern CALCULATION_FORMULA_PATTERN = Pattern.compile("^[0-9]+(\\s[+\\-*/]\\s[0-9]+)+$");
    private static final Scanner sc = new Scanner(System.in);

    @Override
    public int inputButton() {
        String input = sc.nextLine();
        validateButton(input);
        return Integer.parseInt(input);
    }

    private void validateButton(String input) {
        if (!BUTTON_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_BUTTON_NOT_RANGE.getMessage());
        }
    }

    @Override
    public String inputCalculationFormula() {
        String input = sc.nextLine();
        validateCalculateFormula(input);
        return input;
    }

    private void validateCalculateFormula(String input) {
        if (!CALCULATION_FORMULA_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NOT_FORMULA.getMessage());
        }
    }
}
