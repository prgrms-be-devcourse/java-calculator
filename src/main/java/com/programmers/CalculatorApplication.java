package com.programmers;

import com.programmers.io.Console;
import com.programmers.repository.CalculationMemoryRepository;
import com.programmers.repository.CalculationRepository;
import com.programmers.service.CalculationService;

public class CalculatorApplication {
    public static void main(String[] args) {
        CalculationRepository calculationRepository = new CalculationMemoryRepository();
        Console console = new Console();

        new CalculationService(calculationRepository, console, console).run();
    }
}
