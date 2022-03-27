package com.caculator.io;

import com.caculator.repository.Result;

import java.util.List;
import java.util.Scanner;

public class Console implements Input, Output {

    private final Scanner sc = new Scanner(System.in);

    @Override
    public String inputCmd() {
        System.out.println("1. 조회");
        System.out.println("2. 계산");
        System.out.println();
        System.out.print("선택 : ");
        return sc.nextLine().trim();
    }

    @Override
    public String inputExp() {
        return sc.nextLine().trim();
    }

    @Override
    public void printResult(int result) {
        System.out.println(result);
        System.out.println();
    }

    @Override
    public void printError(String errMsg) {
        System.out.println(errMsg);
        System.out.println();
    }

    @Override
    public void printHistory(List<Result> histories) {
        histories.forEach(System.out::println);
        System.out.println();
    }
}
