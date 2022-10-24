package com.programmers.cal.engine.io;

import java.util.Scanner;

public class Console implements Input, Output {

    private static final String MENU_MESSAGE = "번호를 입력하세요\n1. 조회\n2. 계산\n3. 종료\n선택 : ";
    private static final String WRONG_ORDER_MESSAGE = "잘못된 입력입니다.";
    private static final String EXIT_MESSAGE = "종료되었습니다.";

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public String inputOrder() {
        return scanner.nextLine();
    }

    @Override
    public void requestInput() {
        System.out.println(MENU_MESSAGE);
    }

    @Override
    public void printWrongOrder() {
        System.out.println(WRONG_ORDER_MESSAGE);
    }

    @Override
    public void printRecord() {

    }

    @Override
    public void printResult(String result) {

    }

    @Override
    public void printExit() {
        System.out.println(EXIT_MESSAGE);
    }
}
