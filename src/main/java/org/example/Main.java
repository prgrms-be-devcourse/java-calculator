package org.example;

import org.example.calculation.ArithmeticCalculation;
import org.example.calculation.Calculation;
import org.example.exception.BadEquationException;
import org.example.io.ConsoleInput;
import org.example.io.ConsoleOutput;
import org.example.io.IoManager;
import org.example.repository.MemoryRepository;

public class Main {
    public static void main(String[] args) {
        new IoManager(new ArithmeticCalculation(), new ConsoleInput(), new ConsoleOutput(), new MemoryRepository()).run();
    }
}