package calculator.controller;

import static calculator.entity.Menu.getSelectedMenu;
import static calculator.view.InputView.inputMenuNumber;
import static calculator.view.OutputView.printWithLineBreak;
import static calculator.view.OutputView.showQuitMessage;

import calculator.entity.Menu;

public class MainController {

    public void run() {
        Menu selectedMenu = null;

        do {
            try {
                int menuNumber = inputMenuNumber();
                selectedMenu = getSelectedMenu(menuNumber);
            } catch (Exception e) {
                printWithLineBreak(e.getMessage());
            }
        } while (selectedMenu != Menu.QUIT);

        showQuitMessage();
    }
}
