package com.programmers.view;

import com.programmers.domain.Menu;

import java.util.Scanner;

/**
 * 입력
 */

public class Input {
    private static final Scanner scanner = new Scanner(System.in);
    public static int inputMenu(){
        int menuNum = Integer.parseInt(scanner.nextLine());
        System.out.println(); //공백

        return menuNum;
    }

    public static String inputExpression(){
        //todo : StringConverter 이용
        String expression = scanner.nextLine();
        return expression;
    }
}
