package org;

import org.console.InputView;
import org.console.OutputView;
import org.domain.repository.CalculationRepository;
import org.error.ResponseErrorFormat;
import org.service.CalculationService;

public class CalculatorApplication {

    static final CalculationRepository calculationRepository = new CalculationRepository();
    static final CalculationService calculationService = new CalculationService(calculationRepository);

    private static final String FIND_MENU = "1";
    private static final String CALCULATOR_MENU = "2";
    private static final String EXIT_MENU = "3";

    public static void main(String[] args) {

        String menuChoice = "";

        while (!menuChoice.equals(EXIT_MENU)) {

            menuChoice = InputView.inputMenuSelection();

            switch (menuChoice) {
                case FIND_MENU:
                    getCalculationAll();
                    break;
                case CALCULATOR_MENU:
                    calculate();
                    break;
                case EXIT_MENU:
                    exit();
                    break;
                default:
                    other();
            }
        }
    }

    private static void getCalculationAll() {
        calculationService.getCalculationsAll();
    }

    private static void calculate() throws IllegalArgumentException {

        try {
            String operation = InputView.inputOperation();
            calculationService.calculate(operation);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println(ResponseErrorFormat.ERROR_DIVISION_BY_ZERO.getMessage());
        }
    }

    private static void exit() {

        OutputView.exitCalculator();
    }

    private static void other() {

        System.out.println(ResponseErrorFormat.ERROR_NOT_FOUND_MENU.getMessage());
    }
}
