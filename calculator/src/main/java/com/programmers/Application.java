package com.programmers;

import com.programmers.engine.Calculator;
import com.programmers.engine.Console;
import com.programmers.engine.MapStorage;

public class Application {
    public static void main(String[] args) {
        MapStorage mapStorage = new MapStorage();
        Console console = new Console();
        new Calculator(console, console, mapStorage).run();
    }
}