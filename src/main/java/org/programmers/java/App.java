package org.programmers.java;

import org.programmers.java.calculation.Calculation;
import org.programmers.java.console.Console;
import org.programmers.java.repository.FormulaRepository;
import org.programmers.java.repository.FormulaMemoryRepository;
import org.programmers.java.validator.Validator;

public class App {
    public static void main(String[] args){
        Console console = Console.getInstance();
        Calculation calculation = new Calculation();
        FormulaRepository formulaRepository = new FormulaMemoryRepository();
        Validator validator = new Validator(console);
        Calculator calculator = new Calculator(console, console, calculation, formulaRepository, validator);
        calculator.run();
    }
}
