package com.javacalculator.view;

import com.javacalculator.dto.CalculatorRequest;
import com.javacalculator.util.CalculatorSplitter;
import com.javacalculator.util.StringParser;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {

    }

    public static int inputMenuNumber() {
        System.out.printf("%n선택 : ");
        int number = StringParser.parseInt(SCANNER.next());
        System.out.println();
        return number;
    }

    public static CalculatorRequest inputExpression() {
        SCANNER.nextLine();
        String expression = SCANNER.nextLine();

        return new CalculatorRequest(expression, CalculatorSplitter.splitToOperands(expression),
                CalculatorSplitter.splitToOperators(expression));
    }
}
