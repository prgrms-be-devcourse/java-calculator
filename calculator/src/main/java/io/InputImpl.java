package io;

import java.util.Scanner;

public class InputImpl implements Input {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String readLine() {
        return scanner.nextLine();
    }
}
