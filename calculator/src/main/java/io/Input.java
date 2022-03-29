package io;

import java.util.Scanner;

public class Input {
    private final Scanner scanner = new Scanner(System.in);

    public String readLine() {
        return scanner.nextLine();
    }
}
