package com.programmers.cal.engine.io;

import java.util.List;
import java.util.Scanner;

public class Console implements Input, Output {

    private static final String MENU_MESSAGE = "\n번호를 입력하세요\n1. 조회\n2. 계산\n3. 종료\n선택 : ";
    private static final String WRONG_ORDER_MESSAGE = "잘못된 입력입니다.";
    private static final String EXIT_MESSAGE = "종료되었습니다.";
    private static final String ZERO_MESSAGE = "0으로 나눌 수 없습니다.";
    private static final String RECORD_MESSAGE = "데이터가 없습니다.";

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
    public void printRecord(List<String> recordList) {
        recordList.stream()
                .forEach(System.out::println);
    }

    @Override
    public void printResult(String result) {
        System.out.println(result);
    }

    @Override
    public void printExit() {
        System.out.println(EXIT_MESSAGE);
    }

    @Override
    public void printZeroDivision() {
        System.out.println(ZERO_MESSAGE);
    }

    @Override
    public void printNoRecord() {
        System.out.println(RECORD_MESSAGE);
    }
}
