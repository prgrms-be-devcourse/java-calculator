package calculator;

import calculator.controller.CalculatorController;
import calculator.domain.repository.CalculationRepository;
import calculator.service.CalculationService;

public class CalculatorApplication {

    public static void main(String[] args) {

        CalculatorController calculatorController = new CalculatorController(new CalculationService(new CalculationRepository()));

        calculatorController.runCalculator();
    }
}
