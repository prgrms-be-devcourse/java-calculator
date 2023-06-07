package com.devcourse.java.common;

import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String MENU_SELECTION_MESSAGE = "1: 조회\n2: 계산\n\n선택 : ";
    private static final String EXIT_CONFIRM_MESSAGE = "\n주어진 메뉴와 다른 값을 입력했습니다. \n종료하시겠습니까? (Y) : ";

    private Input() {}

    public static int selectMenu() {
        System.out.print(MENU_SELECTION_MESSAGE);
        return readAsInt();
    }

    public static String askIfExiting() {
        System.out.print(EXIT_CONFIRM_MESSAGE);
        return read();
    }

    private static String read() {
        return scanner.nextLine();
    }

    private static int readAsInt() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }
}
