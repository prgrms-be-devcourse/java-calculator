package com.programmers.calculator.view;

import com.programmers.calculator.domain.OperationResult;

import java.util.Scanner;

public class Console implements Input, Output{
    private Scanner sc = new Scanner(System.in);

    @Override
    public String inputStr() {
        return sc.nextLine();
    }

    @Override
    public void setScanner(Scanner sc) {
        this.sc = sc;
    }

    @Override
    public void printString(String str) {
        System.out.print(str);
    }

    @Override
    public void printlnString(String str) {
        System.out.println(str);
    }

    @Override
    public void printNoHistory() {
        System.out.println("출력할 결과가 없습니다.");
    }

    @Override
    public void printHistory(OperationResult result) {
        System.out.println(result);
    }
}
