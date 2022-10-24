package com.programmers.caculator;

import com.programmers.caculator.engine.io.Input;
import com.programmers.caculator.engine.io.Output;

import java.util.Scanner;

public class Console implements Input, Output {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public int selectNumber() {
        System.out.println("1. 조회/n2. 계산");
        System.out.print("선택: ");
        return Integer.parseInt(scanner.nextLine());
    }

    @Override
    public String input(String str) {
        return null;
    }

    @Override
    public void showHistory() {

    }
}
