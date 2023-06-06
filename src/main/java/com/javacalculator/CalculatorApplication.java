package com.javacalculator;

import com.javacalculator.controller.CalculatorController;
import com.javacalculator.domain.Calculator;

public class CalculatorApplication {

    public static void main(String[] args) {
        CalculatorController controller = new CalculatorController(new Calculator());

        controller.runCalculator();
    }
}
