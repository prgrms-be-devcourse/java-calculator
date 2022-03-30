package com.programmers.java.calculator;

import com.programmers.java.calculator.engine.io.Input;
import com.programmers.java.calculator.engine.io.Output;

import java.util.Scanner;

public class Console implements Input, Output {
    private final Scanner scanner = new Scanner(System.in);


    @Override
    public String select(String s) {
        System.out.print("선택 : ");
        return scanner.nextLine();
    }

    @Override
    public String inputQuestion() {
        return scanner.nextLine();
    }

    @Override
    public void print(String s) {
        System.out.println(s);
    }

    @Override
    public void printError(String s) {
        System.out.println("[에러 발생] : " + s);
    }

    @Override
    public void printResult(Integer result) {
        System.out.println(result);
    }
}
