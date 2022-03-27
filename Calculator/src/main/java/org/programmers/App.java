package org.programmers;

import org.programmers.config.AppConfig;
import org.programmers.service.MainService;

public class App {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        new MainService(appConfig.calculateService(), appConfig.console()).run();
    }
}
