package com.devcourse.engine.io;

import java.util.Scanner;

public class InputConsole implements Input {

    Scanner scanner = new Scanner(System.in);

    @Override
    public String inputMenu() {
        System.out.println("----------------------------------");
        System.out.println("0: 종료\n1: 조회\n2: 계산\n\n선택: ");
        return scanner.nextLine();
    }

    @Override
    public String inputExpression() {
        System.out.println("계산식을 입력하세요.");
        return scanner.nextLine();
    }

}
