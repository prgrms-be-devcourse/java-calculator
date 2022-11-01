package com.programmers.kwonjoosung.java.calculator.io;


import java.util.Scanner;
import com.programmers.kwonjoosung.java.calculator.Menu;
import static com.programmers.kwonjoosung.java.calculator.Menu.*;

public class Console {
    private static Scanner scanner = new Scanner(System.in);

    public Menu getMenu() {
        printMenu();
        return switch (inputMenu()) {
            case 0 -> EXIT;
            case 1 -> LOOKUP;
            case 2 -> CALCULATE;
            default -> throw new IllegalArgumentException("0~2번 중 하나를 입력해주세요.");
        };
    }

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

    public String inputExpression() {
        System.out.print("식 >> ");
        return scanner.nextLine();
    }

    public void inputNext() {
        System.out.print("계속하려면 아무 키나 누르십시오...");
        scanner.nextLine();
    }


    public void setScanner(Scanner scan) {
        scanner = scan;
    }


    public void println(String message) {
        System.out.println(message);
    }

    public void printMenu() {
        System.out.println("1. 조회");
        System.out.println("2. 계산");
    }

    public void printExit() {
        System.out.println("프로그램을 종료합니다.");
    }

    public void printMenuError() {
        System.out.println("1 ~ 2번 메뉴 중 하나를 선택해주세요(종료는 99)");
    }

    public void printNullError() {
        System.out.println("조회할 데이터가 없습니다.");
    }

    public void printError(String message) {
        System.out.println("오류 발생!");
        System.out.println(message);
    }
}
