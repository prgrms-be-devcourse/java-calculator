package org.console;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public String inputMenuSelection() {

        OutputView.outputByMenu();

        return scanner.nextLine();
    }
}
