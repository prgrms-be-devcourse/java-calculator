package calculator;

import calculator.controller.CalculatorController;
import calculator.domain.repository.CalculatorRepository;
import calculator.service.CalculatorManager;
import calculator.service.CalculatorService;

public class CalculatorApplication {

    public static void main(String[] args) {
        CalculatorController calculatorController = new CalculatorController(new CalculatorService(new CalculatorRepository(), new CalculatorManager()));
        calculatorController.runCalculator();
    }
}
