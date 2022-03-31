package com.programmers.project.io;

import java.util.Scanner;

public class Console implements Input, Output{
    @Override
    public String input() {
        Scanner sc = new Scanner(System.in);
        String opt = sc.nextLine();

        return opt;
    }

    @Override
    public void print(String str) {
        System.out.println(str);
    }

    @Override
    public void menuMsg() {
        System.out.println("1.조회");
        System.out.println("2.계산\n");
        System.out.println("선택 : ");
    }
}
