package main.calculator;

import main.calculator.engine.model.CalculationRepository;
import main.calculator.engine.model.MemoryCalculationRepository;

public class Main {
    public static void main(String[] args) {

        Console console = new Console();
        CalculationRepository calculationRepository = new MemoryCalculationRepository();
        new Calculator(console,console,calculationRepository).run();
    }
}
