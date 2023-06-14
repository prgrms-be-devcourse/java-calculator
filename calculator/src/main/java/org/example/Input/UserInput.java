package org.example.Input;

import java.util.Scanner;

public class UserInput implements Input {
    Scanner scanner = new Scanner(System.in);
    @Override
    public int inputChoice() {
        return scanner.nextInt();
    }

    @Override
    public String inputExpression() {
        scanner.nextLine();
        return scanner.nextLine();
    }
}
