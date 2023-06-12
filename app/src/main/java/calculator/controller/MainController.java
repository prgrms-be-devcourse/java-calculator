package calculator.controller;

import static calculator.entity.Menu.getSelectedMenu;
import static calculator.entity.Menu.isCalculate;
import static calculator.entity.Menu.isQuit;
import static calculator.view.InputView.inputMenuNumber;
import static calculator.view.OutputView.showMenu;

import calculator.entity.Menu;
import calculator.service.Calculator;

public class MainController {

    private final Calculator calculator;

    public MainController(Calculator calculator) {
        this.calculator = calculator;
    }

    public void run() {
        while (true) {
            showMenu();

            int menuNumber = inputMenuNumber();
            Menu selectedMenu = getSelectedMenu(menuNumber);

            if (isQuit(selectedMenu)) {
                break;
            }

            execute(selectedMenu);
        }
    }

    private void execute(Menu selectedMenu) {
        if (isCalculate(selectedMenu)) {
            calculator.calculate();
        }
    }
}