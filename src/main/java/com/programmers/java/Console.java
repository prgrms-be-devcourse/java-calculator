package com.programmers.java;

import com.programmers.java.engine.io.Input;
import com.programmers.java.engine.io.Output;

import java.util.Scanner;

public class Console implements Input, Output {
    private final Scanner sc = new Scanner(System.in);

    @Override
    public String returnInput(String s) {
        System.out.println(s);
        return sc.nextLine();
    }

    @Override
    public void inquireInput(int s) {
        System.out.println(s + " 번을 선택하셨습니다.");
    }

    @Override
    public void inputError() {
        System.out.println("잘못된 입력입니다.\n");
    }

    @Override
    public void printCalcResult(Long result) {
        System.out.println("결과 : " + result + "\n");
    }

    @Override
    public void errorEmptyRepo() {
        System.out.println("계산 이력이 존재하지 않습니다.");
    }
}
