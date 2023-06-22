package calculator.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public String input() {
        String input = SCANNER.nextLine();

        return input;
    }
}
