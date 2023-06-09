package com.programmers.junho.view;

import java.util.Scanner;

public class ScannerInputView implements InputView{
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public int getSelectedCode() {
        System.out.print("선택 : ");
        return scanner.nextInt();
    }

    @Override
    public String getExpression() {
        System.out.print("식 : ");
        return scanner.nextLine();
    }
}
