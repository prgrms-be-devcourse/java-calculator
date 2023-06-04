package com.javacalculator.view;

import com.javacalculator.dto.CalculatorRequest;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DELIMINATOR = " ";

    private InputView() {

    }

    public static int inputMenuNumber() {
        System.out.printf("%n선택 : ");
        int number = parseInt(SCANNER.next());
        System.out.println();
        return number;
    }

    public static CalculatorRequest inputExpression() {
        SCANNER.nextLine();
        String expression = SCANNER.nextLine();
        List<Integer> operands = new LinkedList<>();
        List<String> operators = new LinkedList<>();

        String[] splits = expression.split(DELIMINATOR);
        for (int i = 0; i < splits.length; i++) {
            if (i % 2 == 0) {
                operands.add(parseInt(splits[i]));
                continue;
            }

            operators.add(splits[i]);
        }
        return new CalculatorRequest(expression, operands, operators);
    }

    private static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력한 값이 정수가 아닙니다.");
        }
    }
}
