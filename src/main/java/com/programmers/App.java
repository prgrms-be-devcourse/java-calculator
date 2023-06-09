package com.programmers;

import com.programmers.engine.JavaCalculator;
import com.programmers.engine.model.Result;

public class App {
    public static void main(String[] args) {
        Console console = new Console();
        Result result = new Result();
        BasicCalculator bc = new BasicCalculator();

        new JavaCalculator(console, console, result, bc).run();
    }
}
