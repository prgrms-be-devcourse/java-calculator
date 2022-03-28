package com.programmers;

import com.programmers.calculator.Calculator;
import com.programmers.calculator.repository.MemoryRepository;
import com.programmers.calculator.service.ArithmeticService;
import com.programmers.calculator.service.ValidatorService;

public class App {
    public static void main(String[] args) {
        Console console = new Console();
        MemoryRepository memoryRepository = new MemoryRepository();
        ArithmeticService arithmeticService = new ArithmeticService();
        ValidatorService validatorService = new ValidatorService();

        new Calculator(console, console, memoryRepository,
                arithmeticService, validatorService).run();
    }
}
