package calculator;

import calculator.engine.Calculation;
import calculator.config.AppConfig;

public class App {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        new Calculation(appConfig.calculationService(),
                appConfig.console(),
                appConfig.console()).run();
    }
}
