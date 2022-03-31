package calculator.module.ui;

import java.util.Scanner;

public class ConsoleUserInterface implements UserInterface{

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String inputString() {
        return scanner.nextLine();
    }

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }
}
