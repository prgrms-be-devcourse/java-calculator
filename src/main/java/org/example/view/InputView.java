package org.example.view;

import org.example.validate.InputValidater;

import java.util.Scanner;

public class InputView {
    private static final String MESSAGE_CHOICE = "선택 : ";

    private final InputValidater inputValidater = new InputValidater();
    private final Scanner sc = new Scanner(System.in);

    String readExpression() {
        String expression = sc.nextLine();

        return expression;
    }

    String readCommand() {
        System.out.print(MESSAGE_CHOICE);
        String command = sc.nextLine();
        System.out.println();

        inputValidater.validateCommand(command);

        return command;
    }
}
