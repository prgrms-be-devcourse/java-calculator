package org.example;

import org.example.controller.CalculatorSystem;
import org.example.domain.Calculator;
import org.example.view.CalculatorView;

public class Main {
    public static void main(String[] args) {
        CalculatorSystem calculatorSystem = new CalculatorSystem();
        CalculatorView calculatorView = new CalculatorView();

        try {
            calculatorSystem.run();
        } catch (IllegalArgumentException e) {
            calculatorView.printExceptionMessage(e.getMessage());
        }
    }
}