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
    public String readFile(String s) {
        return null;
    }

    @Override
    public void inputError() {
        System.out.println("입력이 잘못되었습니다.");
    }

    @Override
    public void printAnswer(Double answer) {
        System.out.println(answer);
    }

    @Override
    public void printHistory(String inputHistory) {

    }
}
