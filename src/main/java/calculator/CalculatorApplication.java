package calculator;

import calculator.controller.CalculatorController;
import calculator.domain.repository.CalculatorRepository;
import calculator.service.CalculatorManager;
import calculator.service.CalculatorService;

public class CalculatorApplication {

    public static void main(String[] args) {
        CalculatorRepository calculatorRepository = new CalculatorRepository();
        CalculatorManager calculatorManager = new CalculatorManager();
        CalculatorService calculatorService = new CalculatorService(calculatorRepository, calculatorManager);

        CalculatorController calculatorController = new CalculatorController(calculatorService);
        calculatorController.runCalculator();
    }
}
