package io;

import validation.InputValidation;
import validation.InputValidationImpl;

import java.util.Scanner;

public class CalculatorScannerInput implements CalculatorInput{
    private static final Scanner sc = new Scanner(System.in);
    private static final InputValidation validation = new InputValidationImpl();

    @Override
    public int inputButton() {
        String input = sc.nextLine();
        validation.validateButton(input);
        return Integer.parseInt(input);
    }

    @Override
    public String inputExpression() {
        String expression = sc.nextLine();
        validation.validateExpression(expression);
        return expression;
    }
}
