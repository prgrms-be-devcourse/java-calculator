package com.programmers.java.io;

import com.programmers.java.exception.MenuInputException;

import java.util.List;
import java.util.Scanner;

public class Screen implements Input, Output {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public int inputMenuNumber() throws MenuInputException{
        int chosenNumber;

        try {
            chosenNumber = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new MenuInputException();
        }

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
