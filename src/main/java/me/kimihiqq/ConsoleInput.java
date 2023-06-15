package me.kimihiqq;

import me.kimihiqq.io.Input;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String nextLine() {
        return scanner.nextLine();
    }

    @Override
    public String nextLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
