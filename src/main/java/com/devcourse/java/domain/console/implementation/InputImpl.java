package com.devcourse.java.domain.console.implementation;

import com.devcourse.java.common.Errors;
import com.devcourse.java.domain.console.Input;

import java.util.Scanner;

import static com.devcourse.java.common.Errors.*;

public class InputImpl implements Input {
    private final Scanner scanner;

    public InputImpl() {
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
