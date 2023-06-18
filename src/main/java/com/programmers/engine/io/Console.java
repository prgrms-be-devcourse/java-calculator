package com.programmers.engine.io;

import java.util.List;
import java.util.Scanner;

public class Console implements Input, Output {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String input() {
        String calculationCommand = scanner.nextLine();
        return calculationCommand;
    }

    @Override
    public String choose() {
        System.out.print("선택 : ");
        String selectionNumber = scanner.nextLine();
        System.out.println();
        return selectionNumber;
    }

    @Override
    public void printStart() {
        System.out.println("1. 조회");
        System.out.println("2. 계산");
        System.out.println();
    }

    @Override
    public void printResult(Integer calculationResult) {
        System.out.println(calculationResult);
        System.out.println();
    }

    @Override
    public void printHistory(List<List<String>> history) {
        history.forEach(e -> {
            String result = new StringBuilder()
                    .append(e.get(0))
                    .append(" = ")
                    .append(e.get(1))
                    .toString();
            System.out.println(result);
        });
        System.out.println();
    }
}
