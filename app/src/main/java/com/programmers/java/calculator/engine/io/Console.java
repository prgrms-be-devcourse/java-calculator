package com.programmers.java.calculator.engine.io;

import java.util.Scanner;

public class Console {
    private final Scanner scanner = new Scanner(System.in);

    public String input(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public void inputError() {
        System.out.println("입력이 잘못 되었습니다.\n");
    }

    public void outputChoiceMessage() {
        System.out.println("0. 종료\n1. 조회\n2. 계산\n");
    }

    public void outputCalculationResult(Double input) {
        System.out.println(input + "\n");
    }

    public void calcError() {
        System.out.println("0으로는 나눌 수 없습니다.\n");
    }
}
