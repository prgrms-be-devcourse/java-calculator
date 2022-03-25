package org.programmers;

import org.programmers.service.CalculateService;
import org.programmers.service.MainService;

public class App {
    public static void main(String[] args) {
        Console console = new Console();
        CalculateService calculateService = new CalculateService();
        new MainService(calculateService, console, console).run();
    }
}
