package com.programmers.view;

import com.programmers.domain.CalculatorType;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private static final int WRONG_NUMBER = -1;
    private static final String FORMAT_FORMULA = "^-?[0-9]+([-+*/]{1}-?[0-9]+)+$";
    private static final int INITIAL_INDEX = 0;
    private static final int PRIOR_INDEX = 1;

    private InputView() {
    }

    public static int selectMenu() {
        String selectNum = scanner.nextLine();
        if (MenuType.containMenuNum(selectNum)) {
            return Integer.parseInt(selectNum);
        }
        System.out.println("잘못 입력하셨습니다! 1, 2, 3 만 선택 가능합니다");
        return WRONG_NUMBER;
    }

    public static String inputString() {
        while (true) {
            System.out.print(System.lineSeparator() + ": ");
            String inputString = scanner.nextLine().replaceAll(" ", "");
            if (!validateFormula(inputString)) {
                System.out.println("제대로된 수식을 입력해주세요.");
                continue;
            }

            String result = transformFormula(inputString);
            System.out.println("result: " + result);
            return result;

        }
    }

    private static String transformFormula(String inputString) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < inputString.length(); i++) {
            char current = inputString.charAt(i);
            if (CalculatorType.containType(current) && !isNegative(inputString, i)) {
                stringBuilder.append(" " + current + " ");
                continue;
            }
            stringBuilder.append(current);
        }
        return stringBuilder.toString();
    }

    private static boolean isNegative(String inputString, int index) {
        if (index == INITIAL_INDEX || CalculatorType.containType(inputString.charAt(index - PRIOR_INDEX))) {
            return true;
        }
        return false;
    }

    private static boolean validateFormula(String inputString) {
        return Pattern.matches(FORMAT_FORMULA, inputString);
    }
}
