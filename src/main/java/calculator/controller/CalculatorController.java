package calculator.controller;

import calculator.domain.model.Menu;
import calculator.error.exception.DivisionByZeroException;
import calculator.error.exception.WrongInputFormulaException;
import calculator.error.exception.WrongInputMenuException;
import calculator.error.exception.WrongInputSymbolException;
import calculator.error.model.ResponseErrorFormat;
import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {

        this.calculatorService = calculatorService;
    }

    public void runCalculator() {
        Menu menu;

        do {
            OutputView.outputByMenu();
            menu = Menu.from(InputView.input());
            catchException(menu);
        } while (!menu.isExitTree());

        OutputView.exitCalculator();
    }

    public void catchException(Menu menu) {

        try {
            if (menu.isFindOne()) {
                calculatorService
                        .getHistoryAll()
                        .forEach(OutputView::outputByCalculationResult);
            } else if (menu.isCalculationTwo()) {
                OutputView.outputByCalculationResult(calculatorService.calculate(InputView.input()));
            } else if (menu.isOther()) {
                throw new WrongInputMenuException(ResponseErrorFormat.FAIL_WRONG_INPUT_MENU);
            }
        } catch (WrongInputFormulaException | WrongInputSymbolException | WrongInputMenuException e) {
            System.out.println(e.getMessage());
        } catch (ArithmeticException | DivisionByZeroException e) {
            System.out.println(ResponseErrorFormat.FAIL_DIVISION_BY_ZERO.getMessage());
        }
    }
}
