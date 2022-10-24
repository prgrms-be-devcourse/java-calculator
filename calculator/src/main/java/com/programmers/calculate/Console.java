package com.programmers.calculate;

import com.programmers.calculate.engine.io.Input;

import java.util.Scanner;

public class Console implements Input {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public int selectNumber() {
        System.out.println("1. 조회/n2. 계산");
        System.out.print("선택: ");
        return Integer.parseInt(scanner.nextLine());
    }
}
