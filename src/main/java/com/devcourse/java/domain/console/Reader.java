package com.devcourse.java.domain.console;

import java.util.Scanner;

import static com.devcourse.java.common.Errors.NOT_A_NUMBER;

public class Reader implements Input {
    private final Scanner scanner;

    public Reader() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String read() {
        return scanner.nextLine();
    }

    @Override
    public int readAsInt() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(NOT_A_NUMBER.toMessage());
        }
    }
}
