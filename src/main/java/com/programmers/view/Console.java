package com.programmers.view;

import com.programmers.model.CalculationResult;

import java.util.List;
import java.util.Scanner;

public class Console implements Input, Output {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String inputMenu() {
        System.out.println("1. 조회");
        System.out.println("2. 계산");
        System.out.println("3. 종료");
        System.out.print("선택 : ");
        return scanner.nextLine().trim();
    }

    @Override
    public String inputFormula() {
        return scanner.nextLine().trim();
    }


    @Override
    public void printRecord(List<CalculationResult> record) {
        record.forEach(System.out::println);
        System.out.println();
    }

    @Override
    public void printMessage(String message) {
        System.out.println(message);
        System.out.println();
    }

    @Override
    public void printResult(long result) {
        System.out.println(result);
        System.out.println();
    }
}
