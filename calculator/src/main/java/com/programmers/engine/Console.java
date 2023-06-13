package com.programmers.engine;

import com.programmers.engine.io.Input;
import com.programmers.engine.io.Output;

import java.util.List;
import java.util.Scanner;

public class Console implements Input, Output {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String input() {
        return scanner.nextLine();
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
    public void printHistory(List<String> history) {
        history.forEach(System.out::println);
        System.out.println();
    }
}
