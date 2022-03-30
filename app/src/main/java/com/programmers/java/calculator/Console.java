package com.programmers.java.calculator;

import com.programmers.java.calculator.engine.io.Input;
import com.programmers.java.calculator.engine.io.Output;

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
        System.out.println("입력이 잘못 되었습니다.\n");
    }

    @Override
    public void outputChoiceMessage() {
        System.out.println("1. 조회\n2. 계산\n");
    }

    @Override
    public void outputCalculationResult(Double input) {
        System.out.println(input + "\n");
    }

    @Override
    public void calcError() {
        System.out.println("0으로는 나눌 수 없습니다.\n");
    }
}
