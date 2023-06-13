package com.programmers.io;

import java.util.Scanner;

public class Console implements Output, Input {

    private static final String MENU_MESSAGE = "1. 조회\n2. 계산\n3. 종료\n";
    private static final String MENU_SELECTION_MESSAGE = "선택 : ";

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void printMenu() {
        System.out.println(MENU_MESSAGE);
        System.out.print(MENU_SELECTION_MESSAGE);
    }

    @Override
    public String readInput() {
        return scanner.nextLine();
    }

    public String getSelection() {
        printMenu();
        return readInput();
    }
}
