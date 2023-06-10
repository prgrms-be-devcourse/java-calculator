package org.programmers.java;

import org.programmers.java.calculate.Calculate;
import org.programmers.java.console.Console;
import org.programmers.java.repository.FormulaRepository;
import org.programmers.java.repository.FormulaMemoryRepository;
import org.programmers.java.validation.Validation;

public class App {
    public static void main(String[] args){
        Console console = Console.getInstance();
        Calculate calculate = new Calculate();
        FormulaRepository formulaRepository = new FormulaMemoryRepository();
        Validation validation = new Validation(console);
        Calculator calculator = new Calculator(console, console, calculate, formulaRepository, validation);
        calculator.run();
    }
}
