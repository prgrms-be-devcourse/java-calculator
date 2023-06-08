package org.example.view;

import java.util.Scanner;

public class InputView {

    private Scanner sc = new Scanner(System.in);

    public int selectWorks() {
        int workNum = sc.nextInt();
        sc.nextLine();
        return workNum;
    }

    public String inputExpression() {
        String expression = sc.nextLine();
        return expression;
    }
}
