package calculator.controller;

import calculator.service.CalculatorService;
import ui.InputView;
import ui.OutputView;
import util.Menu;
import util.model.CalculateRequest;

import java.net.CacheRequest;
import java.util.function.Supplier;

public class CalculatorController {
    private InputView inputView;
    private OutputView outputView;
    private final CalculatorService calculatorService;

    public CalculatorController(InputView inputView, OutputView outputView, CalculatorService calculatorService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.calculatorService = calculatorService;
    }

    public void start() {
        boolean continueCalculator = true;
        while(continueCalculator) {
            continueCalculator = eachExecute();
        }
    }

    private boolean eachExecute() {
        Menu select = userInput(()->{
            outputView.printMenu();
            return inputView.getMenuNumberAfterCheckException();
        });

        return executeMenu(select);
    }

    private boolean executeMenu(Menu menu) {
        if (menu == Menu.END) {
            return false;
        }

        if (menu == Menu.SEARCH) {
            executeSearch();
            return true;
        }

        executeCalc();
        return true;
    }

    private void executeCalc() {
        outputView.printResult(this.calculatorService.calculate(getCalculateRequest()));
    }

    private CalculateRequest getCalculateRequest() {
        return userInput(()->{
            outputView.printEmptyMsg();
            return new CalculateRequest(inputView.getEquationAfterCheckException());
        });
    }

    private <T> T userInput(Supplier<T> input) {
        while (true) {
            try {
                return input.get();
            } catch (RuntimeException exception) {
                outputView.printErrorMsg(exception.getMessage());
            }
        }
    }

    private void executeSearch() {
        outputView.printCalculators(this.calculatorService.getCalculateResults());
    }
}
