package com.programmers;

import com.programmers.calculator.Calculator;
import com.programmers.calculator.repository.MemoryRepository;
import com.programmers.calculator.util.io.Console;

public class App {
    public static void main(String[] args) {
        Console console = new Console();
        new Calculator(console, console, new MemoryRepository()).run();
    }
}
