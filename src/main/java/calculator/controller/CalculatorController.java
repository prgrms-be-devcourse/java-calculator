package calculator.controller;

import calculator.service.CalculatorService;
import exception.LimitErrorException;
import ui.InputView;
import ui.OutputView;
import util.Menu;

public class CalculatorController {
    private static final int ERROR_LIMIT = 5;

    private InputView inputView;
    private OutputView outputView;
    private CalculatorService calculatorService;

    public CalculatorController(InputView inputView, OutputView outputView, CalculatorService calculatorService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.calculatorService = calculatorService;
    }

    public void start() {
        boolean continueCalculator = true;
        while(continueCalculator) {
            try {
                continueCalculator = eachExecute();
            } catch (LimitErrorException exception) {
                return;
            }
        }
    }

    private boolean eachExecute() {
        Menu select = userSelect();
        if (select == Menu.END) {
            return false;
        }

        executeMenu(select);
        return true;
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
        String userInput = getEquation();
        this.calculatorService.addCalculation(userInput);
    }

    private String getEquation() {
        for (int i = 0; i < ERROR_LIMIT; i++) {
            try {
                outputView.printEmptyMsg();
                return inputView.getEquation();
            } catch (RuntimeException exception) {
                outputView.printErrorMsg(exception.getMessage());
                outputView.printLimitMsg(ERROR_LIMIT - i - 1);
            }
        }
        throw new LimitErrorException();
    }

    private void search() {
        this.calculatorService.getCalculateList();
    }
}
