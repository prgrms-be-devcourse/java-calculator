package com.programmers.java.engine.io;

import java.util.Scanner;

public class Console implements Input, Output {
    private final Scanner sc = new Scanner(System.in);

    @Override
    public String ReturnInput(String s) {
        System.out.println(s);
        System.out.print("선택 : ");
        return sc.nextLine();
    }

    @Override
    public String FormulaInput(String s) {
        System.out.println(s);
        return  sc.nextLine();
    }

    @Override
    public void Error(String s) {
        if (s.equals("Input")) {
            System.out.println("잘못된 입력입니다.\n");
        } else if (s.equals("EmptyMap")) {
            System.out.println("계산 이력이 존재하지 않습니다.\n");
        }
    }

    @Override
    public void PrintCalcResult(Long result) {
        System.out.println("결과 : " + result + "\n");
    }

}
