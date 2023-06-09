package com.devcourse.java.domain.console;

import java.util.Scanner;

public class Reader implements Input {
    private final Scanner scanner;

    public Reader() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String read() {
        return scanner.nextLine();
    }
}
