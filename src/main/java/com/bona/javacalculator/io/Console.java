package com.bona.javacalculator.io;

import com.bona.javacalculator.model.InputAndAnswer;

import java.util.List;
import java.util.Scanner;

public class Console implements Input, Output{

    private static final Scanner scanner = new Scanner(System.in);

    //정수인지
    public boolean isLong(double num) {
        return num == (long) num;
    }

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
        boolean isLong = isLong(answer);
        if(isLong){
            Long changeAnswer = answer.longValue();
            System.out.println(changeAnswer);
        }else {
            System.out.println(answer);
        }
    }

    @Override
    public void printAll(List<InputAndAnswer> inputAndAnswerList) {
        for (InputAndAnswer history : inputAndAnswerList) {
            String input = history.getInput();
            Double answer = history.getAnswer();

            System.out.print(input + "=");
            boolean isLong = isLong(answer);
            if(isLong){
                Long changeAnswer = answer.longValue();
                System.out.println(changeAnswer);
            }else {
                System.out.println(answer);
            }
        }
    }

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }
}
