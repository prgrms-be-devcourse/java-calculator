package com.programmers;

import com.programmers.io.Console;
import com.programmers.repository.CalculatorMemoryRepository;
import com.programmers.service.CalculatorService;

public class CalculatorApplication {
    public static void main(String[] args) {
        CalculatorMemoryRepository calculatorRepository = new CalculatorMemoryRepository();
        Console console = new Console();

        new CalculatorService(calculatorRepository, console, console).run();
    }
}
