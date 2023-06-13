package com.programmers.io;

public class Console implements Output {

    private static final String MENU_MESSAGE = "1. 조회\n2. 계산\n3. 종료\n";
    private static final String MENU_SELECTION_MESSAGE = "선택 : ";

    @Override
    public void printMenu() {
        System.out.println(MENU_MESSAGE);
        System.out.print(MENU_SELECTION_MESSAGE);
    }
}
