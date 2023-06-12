package com.programmers;

import com.programmers.engine.io.Input;
import com.programmers.engine.io.Output;

import java.util.Map;
import java.util.Scanner;

public class Console implements Input, Output {
    private final Scanner sc = new Scanner(System.in);
    @Override
    public void showMenu() {
        System.out.println("1. 조회\n2. 계산\n3. 종료\n");
    }

    @Override
    public void inputError() {
        System.out.println("잘못된 입력입니다. 다시 선택해주세요!");
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

    @Override
    public void readAllResults(Map<Integer, String> map) {
        if (map.isEmpty()) {
            System.out.println("계산 이력이 없습니다.");
            return;
        }
        System.out.println();
        map.forEach((key, value) -> System.out.println(value));
        System.out.println();
    }

    @Override
    public void printAnswer(int answer) {
        System.out.println(answer);
    }
}
