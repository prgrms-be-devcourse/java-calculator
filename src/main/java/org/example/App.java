package org.example;

import org.example.compute.ArithmeticCompute;
import org.example.io.ConsoleInput;
import org.example.io.ConsoleOutput;
import org.example.controller.CalculatorController;
import org.example.repository.MemoryEquationRepository;

public class App {
    public static void main(String[] args) {
        new CalculatorController(new ArithmeticCompute(), new ConsoleInput(), new ConsoleOutput(), new MemoryEquationRepository()).run();
    }
}