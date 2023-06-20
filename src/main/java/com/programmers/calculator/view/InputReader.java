package com.programmers.calculator.view;

import java.util.Scanner;

public class InputReader implements Input {

    private final Scanner scanner;

    public InputReader() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String read() {
        return scanner.nextLine();
    }
}
