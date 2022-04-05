package com.programmers.java.calculator.io;

import java.util.Scanner;

public class ConsoleInput implements Input{
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String input(String s) {
        System.out.print(s);
        return scanner.nextLine();
    }
}
