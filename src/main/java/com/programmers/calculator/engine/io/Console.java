package com.programmers.calculator.engine.io;

import java.util.Map;
import java.util.Scanner;

public class Console implements Input, Output {

    private final Scanner scanner = new Scanner(System.in);


    @Override
    public String menuInput(String menuPrompt) {
        System.out.print(menuPrompt);
        return scanner.nextLine();
    }

    @Override
    public String formulaInput(String formulaPrompt) {
        System.out.print(formulaPrompt);
        return scanner.nextLine();
    }

    @Override
    public void endNotification() {
        System.out.println("종료합니다.");
    }

    @Override
    public void calculateResult(String result) {
        System.out.println("결과 : " + result + "\n");
    }

    @Override
    public void formulaList(Map<Integer, String> calculationResult) {
        if (calculationResult.size() == 0) {
            System.out.println("계산 내역이 없습니다.");
            return;
        }
        System.out.println("################## 계산 내역 #################");
        calculationResult
                .forEach((k, v) -> System.out.println(k + ". " + v));
        System.out.println("###########################################");
    }
}
