package com.programmers.view;

import com.programmers.domain.CalculatorType;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static int selectMenu() {
        while (true) {
            System.out.print("1. 조회 " + System.lineSeparator()
                    + "2. 계산" + System.lineSeparator()
                    + "3. 종료 " + System.lineSeparator() + System.lineSeparator()
                    + "선택 : ");
            String selectNum = scanner.nextLine();
            if (MenuType.containMenuNum(selectNum)) {
                return Integer.parseInt(selectNum);
            }
            System.out.println("잘못 입력하셨습니다! 1, 2, 3 만 선택 가능합니다");
        }
    }

    public static String inputString() {
        while (true) {
            System.out.print(System.lineSeparator() + ": ");
            String inputString = scanner.nextLine();

            inputString = inputString.replaceAll("[^-+*/0-9]", "");

            return transformFormula(inputString);
        }
    }

    private static String transformFormula(String inputString) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < inputString.length(); i++) {
            char current = inputString.charAt(i);
            if (CalculatorType.containType(current)) {
                stringBuilder.append(" " + current + " ");
                continue;
            }
            stringBuilder.append(current);
        }
        return stringBuilder.toString();
    }
}
