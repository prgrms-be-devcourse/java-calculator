package com.programmers.calculator.engine.io;

import java.util.Scanner;

public class Console implements Input, Output {

    private final Scanner scanner = new Scanner(System.in);


    @Override
    public String menuInput(String menuPrompt) {
        System.out.print(menuPrompt);
        return scanner.nextLine();
    }

    @Override
    public String formulaInput(String formulaPrompt) {
        System.out.print(formulaPrompt);
        return scanner.nextLine();
    }


    @Override
    public void inputError(Exception e) {
        System.out.println(e);
    }


    @Override
    public void endNotification() {
        System.out.println("종료합니다.");
    }
}
