package main.calculator;

import main.calculator.engine.io.Input;
import main.calculator.engine.io.Output;
import main.calculator.engine.model.CalculationRepository;
import main.calculator.engine.model.MemoryCalculationRepository;

public class Main {
    public static void main(String[] args) {

        Input input = new Console();
        Output output = new Console();
        CalculationRepository calculationRepository = new MemoryCalculationRepository();
        Operator operator = new Operator();
        new Calculator(input, output, calculationRepository, operator).run();
    }
}
