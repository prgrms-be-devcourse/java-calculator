package com.programmers.java.io;

import java.util.List;
import java.util.Scanner;

public class Screen implements Input, Output {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public int inputMenuNumber() {
        int chosenNumber = Integer.parseInt(scanner.nextLine());
        System.out.println();
        return chosenNumber;
    }

    @Override
    public String inputFormula() {
        return scanner.nextLine();
    }

    @Override
    public void printMenu(String menu) {
        System.out.print(menu);
    }

    @Override
    public void printHistory(List<String> history) {
        history.forEach(System.out::println);
    }

    @Override
    public void printFormulaResult(Integer result) {
        System.out.println(result);
        System.out.println();
    }

    @Override
    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
