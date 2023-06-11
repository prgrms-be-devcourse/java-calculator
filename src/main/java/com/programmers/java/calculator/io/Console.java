package com.programmers.java.calculator.io;

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
    public void inputError(String message) {
        System.out.println(message);
    }
}
