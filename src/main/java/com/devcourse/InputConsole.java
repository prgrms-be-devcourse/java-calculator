package com.devcourse;

import com.devcourse.engine.io.Input;

import java.util.Scanner;

public class InputConsole implements Input {

    Scanner scanner = new Scanner(System.in);

    @Override
    public String inputMenu() {
        System.out.println("\n0: 종료\n1: 조회\n2: 계산\n\n실행: ");
        return scanner.nextLine();
    }

    @Override
    public String inputExpression() {
        System.out.println("계산식을 입력하세요.");
        return scanner.nextLine();
    }

}
