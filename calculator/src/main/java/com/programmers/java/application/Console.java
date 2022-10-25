package com.programmers.java.application;

import com.programmers.java.engine.io.Input;
import com.programmers.java.engine.io.Output;

import java.util.Scanner;

public class Console implements Input, Output {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String input(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    @Override
    public void inputError() {
        System.out.println("입력이 잘못되었습니다.\n");
    }

    @Override
    public void printAnswer(Double answer) {
        if (checkInt(answer)) {
            System.out.printf("%d\n\n", answer.intValue());
        } else {
            System.out.printf("%.3f\n\n", answer);
        }
    }

    @Override
    public void printHistory(String inputHistory) {
        System.out.println(inputHistory);
    }

    private boolean checkInt(Double answer) {
        if (answer == Math.floor(answer)) {
            return true;
        } else {
            return false;
        }
    }
}
