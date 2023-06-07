package com.programmers.io;

import java.util.Scanner;

public class Console {

    private final String SELECT_MESSAGE = "선택 : ";
    private final Scanner scanner = new Scanner(System.in);

    public String input() {
        return scanner.nextLine();
    }

    public String initMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append("1. 조회\n");
        sb.append("2. 계산\n");
        sb.append("3. 종료\n");

        System.out.println(sb);
        System.out.print(SELECT_MESSAGE);

        String input = input();
        return input;
    }

    public void printErrorMessage(String errorMsg) {
        System.out.println(errorMsg);
    }

    public void printHistory(String history) {
        System.out.println(history);
    }

    public void printResult(double result) {
        System.out.println(result);
    }

}