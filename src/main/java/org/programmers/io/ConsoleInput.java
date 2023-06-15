package org.programmers.io;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleInput implements Input{
    private final Scanner scanner;

    public ConsoleInput() {
        scanner = new Scanner(System.in);
    }

    public int inputNumber() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine();
            return 0;
        }
    }

    public String inputExpression() {
        scanner.nextLine();
        return scanner.nextLine();
    }
}
