package com.programmers.io;

import java.util.List;
import java.util.Scanner;

public class Console implements Input, Output{
    private final Scanner scanner = new Scanner(System.in);

    //input
    @Override
    public String selectService() {
        System.out.println("1. 조회");
        System.out.println("2. 계산");
        System.out.println("3. 종료");
        System.out.println();

        System.out.print("선택 : ");
        String selected = scanner.nextLine();
        System.out.println();

        return selected;
    }

    @Override
    public String inputCalculation() {
        return scanner.nextLine();
    }

    //output
    @Override
    public void printResult(int result) {
        System.out.println(result);
        System.out.println();
    }

    @Override
    public void printResult(List<String> findCalculations) {
        findCalculations.forEach(System.out::println);
        System.out.println();
    }

    @Override
    public void exit() {
        System.out.println("애플리케이션을 종료합니다.");
        scanner.close();
    }

    @Override
    public void inputError() {
        System.out.println("잘못된 입력입니다.");
        System.out.println();
    }

    @Override
    public void printError(RuntimeException ex) {
        System.out.println(ex.getMessage());
        System.out.println();
    }
}
