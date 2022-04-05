package com.programmers.calculator.engine;

import com.programmers.calculator.engine.io.Input;
import com.programmers.calculator.engine.io.Output;

import java.util.List;
import java.util.Scanner;

public class Console implements Input, Output {
    private final Scanner scanner = new Scanner(System.in);


    @Override
    public String input(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    @Override
    public void printResult(int result) {
        System.out.println("result : " + result);
    }

    @Override
    public void inputError() {
        System.out.println("입력이 잘못되었습니다.");
    }

    @Override
    public void printEnter() {
        System.out.println();
    }

    @Override
    public void printRepository(List<String> data) {
        for(String result : data) {
            System.out.println(result);
        }
    }

    @Override
    public void emptyError() {
        System.out.println("저장된 계산이 없습니다.");
    }
}
