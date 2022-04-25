package com.programmers.project.io;

import java.util.Scanner;

public class Console implements Input, Output{

    @Override
    public String input() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }


    @Override
    public void print(String str) {
        System.out.println(str);
    }

    @Override
    public void menuMsg() {
        System.out.println("\n");
        System.out.println("1.조회");
        System.out.println("2.계산");
        System.out.println("3.종료\n");
        System.out.print("선택 : ");
    }

    @Override
    public void inValidMsg() {
        System.out.println("유효하지 않은 수식입니다. 다시 한번 확인해주세요!");
    }

    @Override
    public void divideByZeroMsg() {
        System.out.println("0으로 나눌 수 없습니다");
    }

    @Override
    public void exitMsg() {
        System.out.println("계산기를 종료합니다.");
    }
}
