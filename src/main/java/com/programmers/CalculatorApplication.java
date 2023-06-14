package com.programmers;

import com.programmers.io.Console;
import com.programmers.repository.CalculatorMemoryRepository;
import com.programmers.repository.CalculatorRepository;
import com.programmers.service.CalculatorService;

public class CalculatorApplication {
    public static void main(String[] args) {
        CalculatorRepository calculatorRepository = new CalculatorMemoryRepository();
        Console console = new Console();

        new CalculatorService(calculatorRepository, console, console).run();
    }
}
