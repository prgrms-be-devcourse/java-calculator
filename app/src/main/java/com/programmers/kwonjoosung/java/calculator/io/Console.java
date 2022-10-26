package com.programmers.kwonjoosung.java.calculator.io;

import java.util.Scanner;

public class Console implements Input, Output { // String으로 입력받고 String 타입 데이터 출력
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public int inputMenu() {
        System.out.print("선택: ");

        int menu;
        try {
            String data = scanner.nextLine();
            menu = Integer.parseInt(data);
            return menu;
        } catch (NumberFormatException ne) {
            System.out.println("숫자를 입력해주세요.");
        }

        return -1; // 메뉴에 속하지 못하는 값 리턴
    }

    @Override
    public String inputExpression() {
        System.out.print("식 >> ");
        return scanner.nextLine();
    }

    @Override
    public void inputNext() {
        System.out.print("계속하려면 아무 키나 누르십시오...");
        scanner.nextLine();
    }

    @Override
    public void setScanner(Scanner scan) {
        scanner = scan;
    }

    @Override
    public void println(String message) {
        System.out.println(message);
    }

    @Override
    public void printMenu() {
        // 여기서 메뉴 내용을 결정해도 되는지? -> 만약 내용의 수정이 있으면 둘다 변경이 일어날텐데?
        System.out.println("1. 조회");
        System.out.println("2. 계산");
    }

    @Override
    public void printExit() {
        System.out.println("프로그램을 종료합니다.");
    }

    @Override
    public void printMenuError() {
        System.out.println("1 ~ 2번 메뉴 중 하나를 선택해주세요(종료는 99)");
    }

    @Override
    public void printNullError() {
        System.out.println("조회할 데이터가 없습니다.");
    }

    @Override
    public void printError(String message) {
        System.out.println("오류 발생!");
        System.out.println(message);
    }
}
