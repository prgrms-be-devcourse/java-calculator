package org.programmers.java;

import org.programmers.java.calculation.Calculation;
import org.programmers.java.repository.FormulaRepository;
import org.programmers.java.repository.FormulaMemoryRepository;

public class App {
    public static void main(String[] args){
        Calculation calculation = new Calculation();
        FormulaRepository formulaRepository = new FormulaMemoryRepository();
        Calculator calculator = new Calculator(calculation, formulaRepository);
        calculator.run();
    }
}
