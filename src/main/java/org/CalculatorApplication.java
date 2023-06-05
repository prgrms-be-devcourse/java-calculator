package org;

import org.application.InputView;
import org.application.OutputView;
import org.domain.repository.CalculationRepository;
import org.error.ResponseErrorFormat;
import org.service.CalculationService;

public class CalculatorApplication {

    public static void main(String[] args) {

        final CalculationRepository calculationRepository = new CalculationRepository();
        final CalculationService calculationService = new CalculationService(calculationRepository);

        String menuChoice = "";

        while (!menuChoice.equals("3")) {

            menuChoice = InputView.inputMenuSelection();

            switch (menuChoice) {
                case "1":
                    calculationService.getCalculationsAll();
                    break;
                case "2":
                    InputView.inputOperation();
                    break;
                case "3":
                    OutputView.exitCalculator();
                    break;
                default :
                    System.out.println(ResponseErrorFormat.ERROR_NOT_FOUND_MENU.getMessage());
            }
        }
    }
}
