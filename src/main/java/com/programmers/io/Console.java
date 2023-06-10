package com.programmers.io;

import com.programmers.validator.InputValidator;

import java.util.Scanner;

public class Console implements Input, Output{

    private final String SELECT_MESSAGE = "선택 : ";
    private final String HISTORY_MESSAGE = "1. 조회\n";
    private final String CALC_MESSAGE = "2. 계산\n";
    private final String END_MESSAGE = "3. 종료\n";

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String input() {
        return scanner.nextLine();
    }

    @Override
    public String initMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append(HISTORY_MESSAGE);
        sb.append(CALC_MESSAGE);
        sb.append(END_MESSAGE);

        System.out.println(sb);
        System.out.print(SELECT_MESSAGE);

        String request = input();
        InputValidator.isEmpty(request);
        InputValidator.checkEquation(request);

        return request;
    }

    @Override
    public void println(String msg) {
        System.out.println(msg);
    }

    public void println(double msg) {
        System.out.println(msg);
    }

    @Override
    public void printErrorMsg(String errMsg) {
        System.out.println(errMsg);
    }
}