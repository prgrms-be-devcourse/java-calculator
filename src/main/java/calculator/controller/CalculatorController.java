package calculator.controller;

import calculator.domain.model.Menu;
import calculator.error.ResponseErrorFormat;
import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {

        this.calculatorService = calculatorService;
    }

    public void runCalculator() throws IllegalArgumentException, ArithmeticException {
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
                calculatorService.getHistoryAll();
            } else if (menu.isCalculationTwo()) {
                calculatorService.calculate(InputView.input());
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println(ResponseErrorFormat.ERROR_DIVISION_BY_ZERO.getMessage());
        }
    }
}
