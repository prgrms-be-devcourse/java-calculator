package com.programmers;

import com.programmers.engine.io.*;

import java.util.Scanner;

public class Console implements Input, Output {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String input(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
