package com.programmers.java;

import com.programmers.java.engin.io.Input;
import com.programmers.java.engin.io.Output;
import com.programmers.java.engin.model.Log;

import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.joining;

public class Console implements Input, Output {

    private final Scanner scanner = new Scanner(System.in);
    static final String NEWLINE = System.lineSeparator();

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
    public void logsView(List<Log> logs) {

        if (logs.size() == 0) {
            System.out.println();
            return;
        }

        String view = logs
                .stream()
                .map(Log::getLog).collect(joining(NEWLINE));
        System.out.println(NEWLINE + view + NEWLINE);

    }

    @Override
    public void answer(String result) {
        System.out.println(result+"\n");
    }

    @Override
    public void errorMessage(String message) {
        System.out.println(message+"\n");
    }
}
