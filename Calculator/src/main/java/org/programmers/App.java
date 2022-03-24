package org.programmers;

import org.programmers.service.MainService;

public class App {
    public static void main(String[] args) {
        MainService mainService = new MainService();
        mainService.runCalculator();
    }
}
