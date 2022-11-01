package com.programmers.io;

import java.util.Scanner;

public class ConsoleInput implements Input{
    private final Scanner scanner = new Scanner(System.in);
    @Override
    public String getinput() {
        return scanner.nextLine();
    }
}
