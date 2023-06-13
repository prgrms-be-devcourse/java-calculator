package com.programmers;

import com.programmers.core.CalculatorManager;
import com.programmers.repository.CalculationRepository;
import com.programmers.repository.InMemoryCalculationRepository;
import com.programmers.view.Console;

public class Main {
    public static void main(String[] args) {
        CalculationRepository repository = new InMemoryCalculationRepository();
        Console console = new Console();
        CalculatorManager calculatorManager = new CalculatorManager(repository, console);
        calculatorManager.run();
    }
}