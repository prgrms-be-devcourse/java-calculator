package com.programmers.project.io;

import java.util.Scanner;

public class Console implements Input, Output{
    @Override
    public String menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1.조회");
        System.out.println("2.계산\n");
        System.out.println("선택 : ");


        String opt = sc.nextLine();

        return opt;
    }
}
