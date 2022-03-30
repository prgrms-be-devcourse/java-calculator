package com.programmers.java;

import com.programmers.java.engine.Calculator;
import com.programmers.java.engine.io.Input;
import com.programmers.java.engine.io.Output;

import java.util.Scanner;

public class Console implements Output, Input {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public int input(String prompt) {
        System.out.println(prompt);
        return scanner.nextInt();
    }

    // 메뉴 상수 번호, 한 곳에서 관리 및 메뉴 의존도 낮추는 방법

    @Override
    public void inputError() {
        System.out.println("입력이 잘못되었습니다.");
    }
}
