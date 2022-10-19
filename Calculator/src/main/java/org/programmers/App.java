package org.programmers;

import org.programmers.config.AppConfig;
import org.programmers.service.MainService;

/**
 * App에서 AppConfig를 생성 후 MainService에 calculateService와 console을 주입했습니다.
 */
public class App {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        new MainService(appConfig.calculateService(appConfig.calculatorRepository()), appConfig.console()).run();
    }
}
