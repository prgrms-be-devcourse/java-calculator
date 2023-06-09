package com.devcourse;

import com.devcourse.engine.io.Input;
import com.devcourse.engine.io.Output;

import java.util.Scanner;

public class Console implements Input, Output {

    Scanner scanner = new Scanner(System.in);

    @Override
    public String menuInput() {
        System.out.println("0: 종료\n1: 조회\n2: 계산\n\n실행: ");
        return scanner.nextLine();
    }

    @Override
    public void endGame() {
        System.out.println("게임을 종료합니다.");
    }
}
