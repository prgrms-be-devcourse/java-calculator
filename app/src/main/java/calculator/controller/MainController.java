package calculator.controller;

import static calculator.entity.Menu.getSelectedMenu;
import static calculator.view.InputView.inputMenuNumber;
import static calculator.view.OutputView.showAllHistory;
import static calculator.view.OutputView.showMenu;

import calculator.entity.Menu;
import calculator.service.Calculator;
import calculator.storage.HistoryStorage;

public class MainController {

    private final HistoryStorage historyStorage;
    private final Calculator calculator;

    public MainController(HistoryStorage historyStorage, Calculator calculator) {
        this.historyStorage = historyStorage;
        this.calculator = calculator;
    }

    public void run() {
        boolean isRunning = true;

        while (isRunning) {
            showMenu();

            int menuNumber = inputMenuNumber();
            Menu selectedMenu = getSelectedMenu(menuNumber);

            isRunning = !selectedMenu.isQuit();

            execute(selectedMenu);
        }
    }

    private void execute(Menu selectedMenu) {
        if (selectedMenu.isReadHistory()) {
            String[] allHistory = historyStorage.readAllHistory();
            showAllHistory(allHistory);

            return;
        }

        if (selectedMenu.isCalculate()) {
            calculator.execute();
        }
    }
}
