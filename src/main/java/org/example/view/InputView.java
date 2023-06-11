package org.example.view;

import java.util.Scanner;

public class InputView {
    //private final Validater validater = new Validater();
    Scanner sc = new Scanner(System.in);
    String readExpression() {
        String expression = sc.nextLine();

        //검증 로직 넣을 것

        return expression;
    }

    Integer readCommand() {
        String command = sc.nextLine();

        //검증 로직 넣을 것

        return Integer.parseInt(command);
    }
}
