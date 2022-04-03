package calculator;

import calculator.config.AppConfig;
import calculator.engine.Calculator;

public class App {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        new Calculator(appConfig.console(),
                appConfig.console(),
                appConfig.calculation(),
                appConfig.parser(),
                appConfig.sorter(),
                appConfig.calculationRepository()
        ).run();
    }
}
