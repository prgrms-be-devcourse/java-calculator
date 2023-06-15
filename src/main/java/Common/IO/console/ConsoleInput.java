package Common.IO.console;

import Common.Exception.WrongValueException;

import java.util.Scanner;

public class ConsoleInput {
    private final Scanner sc = new Scanner(System.in);

    public int getChoice() {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            throw new WrongValueException();
        }
    }

    public String getExpression() {
        return sc.nextLine();
    }
}
