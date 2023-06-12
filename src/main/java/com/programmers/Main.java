package com.programmers;

import com.programmers.controller.CalculatorController;
import com.programmers.service.CalculatorService;

public class Main {
    public static void main(String[] args) {
        CalculatorController controller = new CalculatorController(new CalculatorService());
        controller.run();
    }
}