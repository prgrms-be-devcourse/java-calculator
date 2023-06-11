package org.example.view;

import java.util.Scanner;

public class InputView {
    private static final String MESSAGE_CHOICE = "선택 : ";

    //private final Validater validater = new Validater();
    Scanner sc = new Scanner(System.in);
    String readExpression() {
        String expression = sc.nextLine();

        //검증 로직 넣을 것

        return expression;
    }

    Integer readCommand() {
        System.out.print(MESSAGE_CHOICE);
        String command = sc.nextLine();
        System.out.println();

        //검증 로직 넣을 것

        return Integer.parseInt(command);
    }
}
