package com.programmers;

import com.programmers.engine.JavaCalculator;
import com.programmers.engine.model.Result;

public class App {
    public static void main(String[] args) {
        Console console = new Console();
        Result calculateResult = new Result();
        new JavaCalculator(console, console, calculateResult).run();
    }
}
