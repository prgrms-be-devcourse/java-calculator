package com.programmers;

import com.programmers.engine.io.Input;
import com.programmers.engine.io.Output;

import java.util.Scanner;

public class Console implements Input, Output {
    private final Scanner sc = new Scanner(System.in);
    @Override
    public void showMenu() {
        System.out.println("1. 조회\n2. 계산\n3. 종료\n");
    }

    @Override
    public int selectMenu() {
        System.out.print("선택 : ");
        return Integer.parseInt(sc.nextLine());
    }

    @Override
    public String getExpression() {
        System.out.println("계산하고자 하는 식을 입력해주세요!");
        return sc.nextLine();
    }
}
