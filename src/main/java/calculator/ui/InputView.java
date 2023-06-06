package calculator.ui;

import util.Menu;

import java.util.Scanner;

public class InputView {
    private Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    private String readLine() {
        return this.scanner.nextLine().trim();
    }

    public Menu getMenuNumber() {
        String userInput = readLine();
        CheckInputException.isEmpty(userInput);

        Menu menu = Menu.getMenu(userInput);
        CheckInputException.checkMenuNumber(menu);
        return menu;
    }

    public void getEquation() {
        String userInput = readLine();
        CheckInputException.isEmpty(userInput);

        CheckInputException.checkEquation(userInput);

    }
}
