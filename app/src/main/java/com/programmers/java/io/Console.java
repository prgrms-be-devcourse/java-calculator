package com.programmers.java.io;

import com.programmers.java.exception.MenuInputException;
import com.programmers.java.model.History;

import java.util.List;
import java.util.Scanner;

public class Console implements Input, Output {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String inputMenuNumber() throws MenuInputException {
        String chosenNumber = scanner.nextLine();
        System.out.println();
        return chosenNumber;
    }

    @Override
    public String inputFormula() {
        String formula = scanner.nextLine();
        return formula;
    }

    @Override
    public void printMenu(String menu) {
        System.out.print(menu);
    }

    @Override
    public void printHistory(List<History> history) {
        history.forEach(i -> System.out.println(i.getHistory()));
    }

    @Override
    public void printFormulaResult(Integer result) {
        System.out.println(result);
        System.out.println();
    }

    @Override
    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
        System.out.println();
    }
}
