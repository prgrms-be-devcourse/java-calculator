package com.programmers.calculator.service;

import java.util.Scanner;

public class CalcKeyBoardService {
    Scanner sc = new Scanner(System.in);

    public int selectAction() {
        System.out.println("1. 조회");
        System.out.println("2. 계산");
        System.out.println();

        System.out.print("선택 : ");
        int actionNum = sc.nextInt();
        System.out.println();

        return actionNum;
    }

    public String inputFormula() {
        sc.nextLine();
        return sc.nextLine();
    }
}
