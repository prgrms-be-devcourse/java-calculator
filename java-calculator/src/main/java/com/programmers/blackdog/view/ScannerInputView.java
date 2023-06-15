package com.programmers.blackdog.view;

import java.util.Scanner;

public class ScannerInputView implements InputView {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String read() {
        return scanner.nextLine();
    }
}
