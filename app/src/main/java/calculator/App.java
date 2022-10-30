package calculator;

import calculator.config.AppConfig;
import calculator.controller.CalculatorController;

public class App {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        CalculatorController calculatorService = appConfig.calculatorService();
        calculatorService.run();
    }
}
