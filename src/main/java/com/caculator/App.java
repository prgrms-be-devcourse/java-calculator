package com.caculator;

import com.caculator.io.Console;
import com.caculator.repository.CalculatorRepository;
import com.caculator.repository.MemoryCalculatorRepository;

public class App {

    public static void main(String[] args) {
        CalculatorRepository repository = new MemoryCalculatorRepository();
        Console console = new Console();
        new Calculator(repository, console, console).run();
    }
}
