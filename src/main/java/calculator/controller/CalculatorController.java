package calculator.controller;

import calculator.domain.model.HistoryModel;
import calculator.domain.model.Menu;
import calculator.error.exception.DivisionByZeroException;
import calculator.error.exception.WrongInputFormulaException;
import calculator.error.exception.WrongInputMenuException;
import calculator.error.exception.WrongInputSymbolException;
import calculator.error.model.ResponseErrorFormat;
import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public void runCalculator() {
        Menu menu;

        do {
            OutputView.outputByMenu();
            String menuNumber = InputView.input();
            menu = Menu.from(menuNumber);
            processMenuSelection(menu);
        } while (!menu.isExit());

        OutputView.exitCalculator();
    }

    private void processMenuSelection(Menu menu) {
        if (menu.isFind()) {
            catchAndHandleFindException();
            return;
        }
        if (menu.isCalculation()) {
            catchAndHandleCalculationException();
            return;
        }
        if (menu.isOther()) {
            catchAndHandleOtherException();
        }
    }

    private void catchAndHandleFindException() {
        try {
            List<HistoryModel> historyModels = calculatorService.getHistoryAll();
            OutputView.outputByCalculationResult(historyModels);
        } catch (RuntimeException e) {
            System.out.println(ResponseErrorFormat.FAIL_UNSPECIFIED_EXCEPTION.getMessage() + e.getMessage());
        }
    }

    private void catchAndHandleCalculationException() {
        try {
            String formula = InputView.input();
            HistoryModel historyModel = calculatorService.calculate(formula);
            OutputView.outputByCalculationResult(historyModel);
        } catch (WrongInputFormulaException | WrongInputSymbolException e) {
            System.out.println(e.getMessage());
        } catch (ArithmeticException | DivisionByZeroException e) {
            System.out.println(ResponseErrorFormat.FAIL_DIVISION_BY_ZERO.getMessage());
        }
    }

    private void catchAndHandleOtherException() {
        try {
            throw new WrongInputMenuException(ResponseErrorFormat.FAIL_WRONG_INPUT_MENU);
        } catch (WrongInputMenuException e) {
            System.out.println(e.getMessage());
        }
    }
}
