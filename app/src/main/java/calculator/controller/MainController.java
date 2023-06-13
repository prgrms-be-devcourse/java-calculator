package calculator.controller;

import static calculator.entity.Menu.getSelectedMenu;
import static calculator.view.InputView.inputMenuNumber;
import static calculator.view.OutputView.showMenu;

import calculator.entity.Menu;
import calculator.service.Calculator;
import calculator.service.HistoryReader;

public class MainController {

    private final HistoryReader historyReader;
    private final Calculator calculator;

    public MainController(HistoryReader historyReader, Calculator calculator) {
        this.historyReader = historyReader;
        this.calculator = calculator;
    }

    public void run() {
        while (true) {
            showMenu();

            int menuNumber = inputMenuNumber();
            Menu selectedMenu = getSelectedMenu(menuNumber);

            if (selectedMenu.isQuit()) {
                break;
            }

            execute(selectedMenu);
        }
    }

    private void execute(Menu selectedMenu) {
        if (selectedMenu.isReadHistory()) {
            historyReader.execute();
            return;
        }

        if (selectedMenu.isCalculate()) {
            calculator.execute();
        }
    }
}
