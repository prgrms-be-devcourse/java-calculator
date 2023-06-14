package com.programmers.calculator.view;

import java.util.Scanner;

public class InputConsole implements Input {

    private Scanner scanner;

    public InputConsole(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String inputOption() {
        System.out.print("\n선택 : ");
        return scanner.next();
    }

    @Override
    public String inputExpression() {
        System.out.println();
        scanner.nextLine();
        return scanner.nextLine();
    }
}

