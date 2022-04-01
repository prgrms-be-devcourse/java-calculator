package com.programmers.java.calculator.io;

import java.util.Scanner;

public class ConsoleInput implements Input{

    private final Scanner sc = new Scanner(System.in);

    @Override
    public int inputCmd() {
        System.out.println("1. 조회");
        System.out.println("2. 계산");
        System.out.print("선택 : ");
        return Integer.parseInt(sc.nextLine().trim());
    }

    @Override
    public String inputExp() {
        System.out.println();
        return sc.nextLine().trim();
    }
}
