package org.example.Input;

import java.util.Scanner;

public class UserType implements Type{
    Scanner scanner = new Scanner(System.in);
    @Override
    public int typeChoice() {
        return scanner.nextInt();
    }

    @Override
    public String typeExpression() {
        scanner.nextLine();
        return scanner.nextLine();
    }
}
