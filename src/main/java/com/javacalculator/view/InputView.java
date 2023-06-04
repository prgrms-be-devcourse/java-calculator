package com.javacalculator.view;

import java.util.Scanner;

public class InputView {

    private static Scanner SCANNER = new Scanner(System.in);

    private InputView() {

    }

    public static int inputMenuNumber() {
        try {
            System.out.printf("%n선택 : ");
            return SCANNER.nextInt();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력한 값이 정수가 아닙니다.");
        }
    }
}
