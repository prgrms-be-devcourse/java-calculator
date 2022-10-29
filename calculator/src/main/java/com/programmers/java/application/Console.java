package com.programmers.java.application;

import com.programmers.java.engine.io.Input;
import com.programmers.java.engine.io.Output;
import com.programmers.java.engine.model.Answer;
import com.programmers.java.engine.model.EquationRecord;

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
        System.out.println(answer.getStringValue() + "\n");
    }

    @Override
    public void printHistory(EquationRecord record) {
        System.out.println(record.toString());
    }
}
