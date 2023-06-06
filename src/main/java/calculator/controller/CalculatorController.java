package calculator.controller;

import calculator.domain.model.Menu;
import calculator.domain.model.Message;
import calculator.error.ResponseErrorFormat;
import calculator.service.CalculationService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    private final CalculationService calculationService;

    public CalculatorController(CalculationService calculationService) {

        this.calculationService = calculationService;
    }

    public void runCalculator() throws IllegalArgumentException, ArithmeticException {

        Menu menu;

        do {
            OutputView.outputByMenu();

            menu = Menu.from(InputView.input());

            catchException(menu);

        } while (!menu.isExitTree());

        Message.exitMessage();
    }

    public void catchException(Menu menu) {

        try {
            if (menu.isFindOne()) {
                calculationService.getCalculationsAll();
            } else if (menu.isCalculationTwo()) {
                calculationService.calculate(InputView.input());
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println(ResponseErrorFormat.ERROR_DIVISION_BY_ZERO);
        }
    }
}
