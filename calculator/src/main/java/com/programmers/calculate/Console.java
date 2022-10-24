package com.programmers.calculate;

import com.programmers.calculate.engine.io.Input;
import com.programmers.calculate.engine.io.Output;

import java.util.Scanner;

public class Console implements Input, Output {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public int selectNumber() {
        System.out.println("1. 조회\n2. 계산\n3. 종료");
        System.out.print("선택: ");
        return Integer.parseInt(scanner.nextLine());
    }

    @Override
    public String inputExpression() {
        System.out.print("\n계산 식을 입력하세요: ");
        return scanner.nextLine();
    }

    @Override
    public void valueError() {
        System.out.println("잘못된 입력 값입니다.");
    }
}
