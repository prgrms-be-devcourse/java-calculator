package com.programmers.calculator;

import com.programmers.calculator.entity.Operation;

import java.util.Scanner;

public class Console{
    private Scanner sc = new Scanner(System.in);

    public String inputStr() {
        return sc.nextLine();
    }
    public void printString(String str) {
        System.out.print(str);
    }
    public void printlnString(String str) {
        System.out.println(str);
    }
    public void printNoHistory() {
        System.out.println("출력할 결과가 없습니다.");
    }
    public void printHistory(Operation result) {
        System.out.println(result);
    }
}
