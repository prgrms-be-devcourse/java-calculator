package org;

import org.application.InputView;
import org.application.OutputView;
import org.domain.repository.CalculationRepository;
import org.error.ResponseErrorFormat;
import org.service.CalculationService;

public class CalculatorApplication {

    static final CalculationRepository calculationRepository = new CalculationRepository();
    static final CalculationService calculationService = new CalculationService(calculationRepository);

    public static void main(String[] args) {

        String menuChoice = "";

        while (!menuChoice.equals("3")) {
            menuChoice = InputView.inputMenuSelection();
            choice(menuChoice);
        }
    }

    private static void choice(String choice) {

        switch (choice) {
            case "1":
                getCalculationAll();
                break;
            case "2":
                calculate();
                break;
            case "3":
                exit();
                break;
            default:
                other();
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
