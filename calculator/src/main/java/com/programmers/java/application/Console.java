package com.programmers.java.application;

import com.programmers.java.engine.io.Input;
import com.programmers.java.engine.io.Output;
import com.programmers.java.engine.model.Answer;

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
    public void printAnswer(Answer answer) {
        if (checkInt(answer)) {
            System.out.printf("%d\n\n", answer.getValue().intValue());
        } else {
            System.out.printf("%.3f\n\n", answer.getValue());
        }
    }

    @Override
    public void printHistory(String inputHistory) {
        System.out.println(inputHistory);
    }

    private boolean checkInt(Answer answer) {
        if (answer.getValue() == Math.floor(answer.getValue())) {
            return true;
        } else {
            return false;
        }
    }
}
