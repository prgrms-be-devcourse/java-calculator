package org.example.view;

import java.util.Scanner;

public class InputView {
    //1과 2만 입력되도록 하는 정규식 필요
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
