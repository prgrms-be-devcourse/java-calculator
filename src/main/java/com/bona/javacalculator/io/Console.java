package com.bona.javacalculator.io;

import com.bona.javacalculator.model.ExpressionResult;
import com.bona.javacalculator.util.Validator;

import java.util.List;
import java.util.Scanner;

public class Console implements Input, Output {

    private final Scanner scanner = new Scanner(System.in);


    @Override
    public String input(String input) {
        System.out.println(input);
        return scanner.nextLine();
    }

    @Override
    public void inputError() {
        System.out.println("입력을 잘못하셨습니다.");
    }

    @Override
    public void outAnswer(Double answer) {
        boolean isLong = Validator.isLong(answer);
        if (isLong) {
            Long changeAnswer = answer.longValue();
            System.out.println(changeAnswer);
        } else {
            System.out.println(answer);
        }
    }

    @Override
    public void printAll(List<ExpressionResult> expressionResultList) {
        for (ExpressionResult history : expressionResultList) {
            String input = history.getInput();
            Double answer = history.getAnswer();

            System.out.print(input + "=");
            boolean isLong = Validator.isLong(answer);
            if (isLong) {
                Long changeAnswer = answer.longValue();
                System.out.println(changeAnswer);
            } else {
                System.out.println(answer);
            }
        }
    }

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }
}
