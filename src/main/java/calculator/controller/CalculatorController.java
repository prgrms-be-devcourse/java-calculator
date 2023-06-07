package calculator.controller;

import ui.InputView;
import ui.OutputView;
import util.Menu;

public class CalculatorController {
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
        while(true) {
            try {
                outputView.printMenu();
                return inputView.getMenuNumber();
            } catch (RuntimeException exception) {
                outputView.printErrorMsg(exception.getMessage());
            }
        }
    }

    private void executeMenu(Menu menu) {
        if (menu == Menu.CALC) {
            calcEquation();
            return;
        }

        search();
    }

    private void calcEquation() {

    }

    private void search() {

    }
}
