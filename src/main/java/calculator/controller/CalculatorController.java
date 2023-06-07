package calculator.controller;

import exception.LimitErrorException;
import ui.InputView;
import ui.OutputView;
import util.Menu;

public class CalculatorController {
    private static final int ERROR_LIMIT = 5;

    private InputView inputView;
    private OutputView outputView;

    public CalculatorController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
    }

    public void start() {
        while(true) {
            Menu select = userSelect();
            if (select == Menu.END) {
                break;
            }

            executeMenu(select);
        }
    }

    private Menu userSelect() {
        for(int i = 0; i < ERROR_LIMIT; i++) {
            try {
                outputView.printMenu();
                return inputView.getMenuNumber();
            } catch (RuntimeException exception) {
                outputView.printErrorMsg(exception.getMessage());
                outputView.printLimitMsg(ERROR_LIMIT - i - 1);
            }
        }
        throw new LimitErrorException();
    }

    private void executeMenu(Menu menu) {
        if (menu == Menu.SEARCH) {
            search();
            return;
        }

        calcEquation();
    }

    private void calcEquation() {

    }

    private void search() {

    }
}
