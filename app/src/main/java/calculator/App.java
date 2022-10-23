package calculator;

import calculator.config.AppConfig;
import calculator.service.CalculatorService;

public class App {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        CalculatorService calculatorService = appConfig.calculatorService();
        calculatorService.run();
    }
}
