package org.example;

import org.example.calculation.ArithmeticCompute;
import org.example.io.ConsoleInput;
import org.example.io.ConsoleOutput;
import org.example.calculation.Calculator;
import org.example.repository.MemoryRepository;

public class App {
    public static void main(String[] args) {
        new Calculator(new ArithmeticCompute(), new ConsoleInput(), new ConsoleOutput(), new MemoryRepository()).run();
    }
}