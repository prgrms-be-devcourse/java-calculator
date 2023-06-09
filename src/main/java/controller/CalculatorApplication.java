package controller;


import exception.CalculatorException;
import model.MenuService;

import static view.InputView.inputClose;
import static view.InputView.selectMenuInput;
import static view.OutputView.*;


public class CalculatorApplication {
    private final MenuService menuService;
    private boolean runFlag;

    public CalculatorApplication(final MenuService menuService) {
        this.menuService = menuService;
        this.runFlag = true;
    }

    public void run() throws CalculatorException {
        while (isAppTurnOn()) {
            printSelectMenu();
            Menu userSelectMenu = selectMenuInput();
            if (userSelectMenu == Menu.END) {
                inputClose();
                appTurnOff();
            }
            menuService.menuService(userSelectMenu);
        }
    }

    private boolean isAppTurnOn() {
        return runFlag;
    }

    private void appTurnOff() {
        printTurnOff();
        this.runFlag = false;
    }
}
