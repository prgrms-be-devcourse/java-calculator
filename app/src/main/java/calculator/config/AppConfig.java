package calculator.config;

import calculator.domain.BaseCalculation;
import calculator.domain.BaseCalculator;
import calculator.domain.Calculator;
import calculator.repository.ListCalculatorRepository;
import calculator.service.BaseCalculatorService;
import calculator.service.CalculatorService;

public class AppConfig {

    private static final Calculator calculator = new BaseCalculator(new BaseCalculation(), new ListCalculatorRepository());
    private static final CalculatorService calculatorService = new BaseCalculatorService(calculator);

    public CalculatorService calculatorService() {
        return calculatorService;
    }
}