package calculator.console;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String inputMenuSelection() {

        OutputView.outputByMenu();

        return scanner.nextLine();
    }

    public static String inputOperation() {

        return scanner.nextLine();
    }
}
