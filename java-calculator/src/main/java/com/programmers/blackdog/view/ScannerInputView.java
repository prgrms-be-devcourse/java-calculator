package com.programmers.junho.view;

import java.util.Scanner;

public class ScannerInputView implements InputView{
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public String read() {
        scanner.nextLine();
        return scanner.nextLine();
    }
}
