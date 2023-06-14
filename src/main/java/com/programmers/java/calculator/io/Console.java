package com.programmers.java.calculator.io;

import com.programmers.java.calculator.entity.CalculationHistory;

import java.util.List;
import java.util.Scanner;

public class Console implements Input, Output {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String input(String prompt) {
        System.out.print(prompt);
        String inputValue = scanner.nextLine();
        System.out.println();
        return inputValue;
    }

    @Override
    public String input() {
        return scanner.nextLine();
    }

    @Override
    public void inputError(String message) {
        System.out.println(message);
    }

    @Override
    public void print(String message) {
        System.out.println(message);
        System.out.println();
    }

    @Override
    public void printHistoryList(List<CalculationHistory> historyList) {
        historyList.stream().forEach(history -> System.out.println(history.getExpression() + " = " + history.getResult()));
        System.out.println();
    }
}
