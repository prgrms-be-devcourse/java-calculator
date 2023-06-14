package com.programmers.java.calculator;

import com.programmers.java.calculator.engine.io.Input;
import com.programmers.java.calculator.engine.io.Output;

import java.util.Scanner;

public class Console implements Input, Output {
    private final Scanner scanner = new Scanner(System.in);

    public static void printMenu(){
        System.out.println("1. 조회");
        System.out.println("2. 계산");
        System.out.println("9. 종료");
        System.out.print("선택 : ");
    }

    @Override
    public String input(String s) {
        System.out.println(s);
        return scanner.nextLine();
    }

    @Override
    public int parseToInt(String s) {
        return Integer.parseInt(s);
    }

    @Override
    public void goal(int answer) {
        System.out.println(answer);
    }
}