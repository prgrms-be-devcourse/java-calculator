package com.programmers.junho.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    public static int getChoseValue() {
        System.out.print("선택 : ");
        return scanner.nextInt();
    }

    public static String getExpression() {
        return scanner.nextLine();
    }
}
