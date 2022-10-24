package com.programmers.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int selectMenu() {
        while (true) {
            System.out.print("1. 조회 \n2. 계산 \n\n선택: ");
            String selectNum = scanner.nextLine();
            if (selectNum.equals("1") || selectNum.equals("2")) {
                return Integer.parseInt(selectNum);
            }
            System.out.println("잘못 입력하셨습니다! 1 또는 2 만 선택 가능합니다");
        }
    }

    public static String inputString() {
        System.out.print("\n: ");
        String inputString = scanner.nextLine();
        inputString = inputString.replaceAll("[^-+*/0-9]", "");

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < inputString.length(); i++) {
            char current = inputString.charAt(i);
            if (current == '+' || current == '-' || current == '*' || current == '/') {
                stringBuilder.append(" " + current + " ");
                continue;
            }
            stringBuilder.append(current);
        }
        return stringBuilder.toString();
    }
}
