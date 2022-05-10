package com.programmers.java.calculation;

import com.programmers.java.calculation.io.Input;
import com.programmers.java.calculation.io.Output;

import java.util.Scanner;

public class Console implements Input, Output {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String input(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    @Override
    public void wrongInput() {
        System.out.println("잘못된 입력입니다.");
    }

    @Override
    public void correct(Object answer) {
        System.out.println("answer = " + answer);
    }

}
