package com.programmers.io;

import java.util.Scanner;

public class Console {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static String inputMenuNumber() {
        System.out.print("\n선택 : ");
        return SCANNER.nextLine();
    }

    public static String inputExpression() {
        return SCANNER.nextLine();
    }

    public static void printMenu() {
        System.out.println("1. 조회");
        System.out.println("2. 계산");
        System.out.println("3. 종료");
    }

    public static void printError(String errorMsg) {
        System.out.println(errorMsg);
    }

    public static void printHistory(String history) {
        System.out.println(history);
    }

    public static void printResult(String result) {
        System.out.println(result);
    }

    public static void printExit() {
        System.out.println("프로그램이 종료되었습니다.");
    }
}
