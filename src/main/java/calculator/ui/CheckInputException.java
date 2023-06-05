package calculator.ui;

import exception.NotMenuFormatExcpetion;
import exception.NotMenuFormatExcpetion;
import util.Menu;

public class CheckInputException {
    public static void checkMenuNumber(Menu menu) {
        if (menu == Menu.EMPTY) {
            throw new NotMenuFormatExcpetion();
        }
    }

    public static void isEmpty(String userInput) {
        if (userInput == null || userInput.isBlank()) {
            throw new NotMenuFormatExcpetion();
        }
    }
}
