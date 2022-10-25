package com.programmers.java;

import com.programmers.java.engin.io.Input;
import com.programmers.java.engin.io.Output;
import com.programmers.java.engin.model.Logs;

import java.util.Scanner;

public class Console implements Input, Output {
    private final Scanner scanner = new Scanner(System.in);
    @Override
    public String input() {
        return scanner.nextLine();
    }

    @Override
    public String input(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    @Override
    public void logView(Logs logs) {
        System.out.println(logs.toString());
    }

    @Override
    public void answer(int result) {
        System.out.println(result+"\n");
    }

    @Override
    public void errorMessage(String message) {
        System.out.println(message+"\n");
    }
}
