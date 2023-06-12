package com.wonu606.io;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleInput implements Input {

    Scanner scanner = new Scanner(System.in);

    @Override
    public String getInput() {
        return scanner.nextLine();
    }

    @Override
    public void tearDown() {
        scanner.close();
    }
}
