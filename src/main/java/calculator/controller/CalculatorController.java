package calculator.controller;

import calculator.service.CalculatorService;
import exception.LimitErrorException;
import ui.InputView;
import ui.OutputView;
import util.Menu;

import java.util.function.Function;
import java.util.function.Supplier;

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
        Menu select = userInput(()->{
            outputView.printMenu();
            return inputView.getMenuNumber();
        });

        if (select == Menu.END) {
            return false;
        }

        executeMenu(select);
        return true;
    }

    private void executeMenu(Menu menu) {
        if (menu == Menu.SEARCH) {
            executeSearch();
            return;
        }

        executeCalc();
    }

    private void executeCalc() {
        Double result = userInput(()->{
            outputView.printEmptyMsg();
            return this.calculatorService.calculate(inputView.getEquation());
        });
        outputView.printResult(result);
    }

    private <T> T userInput(Supplier<T> input) {
        for (int tryIndex = 0; tryIndex < ERROR_LIMIT; tryIndex++) {
            try {
                return input.get();
            } catch (RuntimeException exception) {
                outputView.printErrorMsg(exception.getMessage());
                outputView.printLimitMsg(ERROR_LIMIT - tryIndex - 1);
            }
        }
        throw new LimitErrorException();
    }

    private void executeSearch() {
        outputView.printCalculators(this.calculatorService.getCalculateList());
    }
}
