package com.programmers.java.io.console;

import com.programmers.java.io.Input;

import java.util.Scanner;

public class ConsoleInput implements Input {

    Scanner sc = new Scanner(System.in);

    @Override
    public String getExpression() {
        return sc.nextLine().replace(" ", "");
    }

    @Override
    public String getOrder() {
        System.out.println("1. 조회\n2. 계산\n3. 프로그램 종료");
        return sc.nextLine().strip();
    }
}
