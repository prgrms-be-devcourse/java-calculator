package example.calculator.view;

import java.util.Scanner;

public class Input {
    private Scanner scanner;

    public Input() {
        scanner = new Scanner(System.in);
    }

    public int getIntInput() {
        return scanner.nextInt();
    }

    public String getStringInput() {
        return scanner.nextLine();
    }
}
