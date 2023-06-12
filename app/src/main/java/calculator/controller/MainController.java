package calculator.controller;

import static calculator.entity.Menu.getSelectedMenu;
import static calculator.entity.Menu.isQuit;
import static calculator.view.InputView.inputMenuNumber;
import static calculator.view.OutputView.showMenu;

import calculator.entity.Menu;

public class MainController {

    public void run() {
        while (true) {
            showMenu();

            int menuNumber = inputMenuNumber();
            Menu selectedMenu = getSelectedMenu(menuNumber);

            if (isQuit(selectedMenu)) {
                break;
            }
        }
    }
}
