package com.programmers.calculator.view;

public class OutputConsole implements Output {

    @Override
    public void outputOption() {
        System.out.println("\n0. 종료");
        System.out.println("1. 조회");
        System.out.println("2. 계산");
    }

    @Override
    public void outputExit() {
        System.out.println("프로그램이 종료됩니다.");
    }

    @Override
    public void outputHistory() {
        System.out.println("계산 이력 조회");
    }

    @Override
    public void outputCalculation() {
        System.out.println("계산 기능 수행");
    }
}
