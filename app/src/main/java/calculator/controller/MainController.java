package calculator.controller;

import static calculator.entity.Menu.getSelectedMenu;
import static calculator.entity.Menu.isQuit;
import static calculator.view.InputView.inputMenuNumber;

import calculator.entity.Menu;
import java.util.Optional;

public class MainController {

    public void run() {
        Optional<Menu> selectedMenu = Optional.empty();

        while (!isQuit(selectedMenu)) {
            int menuNumber = inputMenuNumber();
            selectedMenu = getSelectedMenu(menuNumber);
        }
    }
}
