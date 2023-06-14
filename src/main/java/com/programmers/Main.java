package com.programmers;

import com.programmers.controller.CalculatorController;
import com.programmers.repository.CalculatorRepository;
import com.programmers.service.CalculatorService;

public class Main {
    public static void main(String[] args) {
        CalculatorRepository calculatorRepository = new CalculatorRepository();
        CalculatorService calculatorService = new CalculatorService(calculatorRepository);
        CalculatorController controller = new CalculatorController(calculatorService);
        controller.run();
    }
}