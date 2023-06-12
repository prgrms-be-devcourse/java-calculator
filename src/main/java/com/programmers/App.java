package com.programmers;

import com.programmers.engine.JavaCalculator;
import com.programmers.engine.model.ResultManager;

public class App {
    public static void main(String[] args) {
        Console console = new Console();
        ResultManager resultManager = new ResultManager();
        BasicCalculator bc = new BasicCalculator();

        new JavaCalculator(console, console, resultManager, bc).run();
    }
}
