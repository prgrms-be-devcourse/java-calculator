package ui;

import util.Menu;
import util.ValidationInput;

import java.util.Scanner;

public class InputView {
    private Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    private String readLine() {
        return this.scanner.nextLine().trim();
    }

    public Menu getMenuNumberAfterCheckException() {
        String userInput = readLine();
        ValidationInput.isEmpty(userInput);
        return Menu.getMenu(userInput);
    }

    public String getEquationAfterCheckException() {
        String userInput = readLine();
        ValidationInput.isEmpty(userInput);

        ValidationInput.checkEquation(userInput);
        return userInput;
    }
}
