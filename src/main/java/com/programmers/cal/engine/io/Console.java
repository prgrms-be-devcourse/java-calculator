package com.programmers.cal.engine.io;

import java.util.List;
import java.util.Scanner;

public class Console implements Input, Output {
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public String inputOrder() {
        return scanner.nextLine();
    }

    @Override
    public void requestInput() {
        System.out.println(Message.MENU_MESSAGE);
    }

    @Override
    public void printWrongOrder() {
        System.out.println(Message.WRONG_ORDER_MESSAGE);
    }

    @Override
    public void printRecord(List<String> recordList) {
        recordList.forEach(System.out::println);
    }

    @Override
    public void printResult(String result) {
        System.out.println(result);
    }

    @Override
    public void printExit() {
        System.out.println(Message.EXIT_MESSAGE);
    }

    @Override
    public void printZeroDivision() {
        System.out.println(Message.ZERO_MESSAGE);
    }

    @Override
    public void printNoRecord() {
        System.out.println(Message.NO_RECORD_MESSAGE);
    }
}
