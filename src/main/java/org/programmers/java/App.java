package org.programmers.java;

import org.programmers.java.calculation.Calculation;
import org.programmers.java.calculation.InfixToPostfixConverter;
import org.programmers.java.calculation.PostfixCalculation;
import org.programmers.java.console.Console;
import org.programmers.java.repository.FormulaRepository;
import org.programmers.java.repository.FormulaMemoryRepository;
import org.programmers.java.validator.Validator;

public class App {
    public static void main(String[] args){
        Calculation calculation = new Calculation();
        FormulaRepository formulaRepository = new FormulaMemoryRepository();
        Calculator calculator = new Calculator(calculation, formulaRepository);
        calculator.run();
    }
}
