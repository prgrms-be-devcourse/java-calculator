package io;

import exception.ExceptionMessage;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CalculatorConsole implements CalculatorOutput, CalculatorInput {
    private static final String BUTTON_INIT_MESSAGE = "1. 조회\n2. 계산";
    private static final String BUTTON_CHOICE_MESSAGE = "선택 : ";
    private static final String RECORD_MESSAGE = "%s = %d";
    private static final Pattern BUTTON_PATTERN = Pattern.compile("^[1-2]$");
    private static final Pattern CALCULATION_FORMULA_PATTERN = Pattern.compile("^[0-9]+(\\s[+\\-*/]\\s[0-9]+)+$");

    private final Scanner sc = new Scanner(System.in);

    @Override
    public void printButtonMessage() {
        System.out.println(BUTTON_INIT_MESSAGE);
        System.out.print(BUTTON_CHOICE_MESSAGE);
    }

    @Override
    public void printResult(int result) {
        System.out.println(result);
    }

    @Override
    public void printRecords(String record, int result) {
        System.out.printf(RECORD_MESSAGE, record, result);
    }

    @Override
    public int inputButton() {
        String input = sc.next();
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
