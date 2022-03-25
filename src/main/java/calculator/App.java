package calculator;

import calculator.engine.Calculator;
import calculator.config.AppConfig;

public class App {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        new Calculator(appConfig.calculationService(),
                appConfig.console(),
                appConfig.console()).run();
    }
}
