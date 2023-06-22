package org.programmers;

import org.programmers.Io.Console;
import org.programmers.calculator.Calculator;
import org.programmers.calculator.Calculate;
import org.programmers.repository.CalRepository;
import org.programmers.repository.CalRepositoryImpl;
import org.programmers.validator.Validator;

public class Application {
    public static void main(String[] args) {
        Console console = new Console();
        Calculate calculate = new Calculate();
        CalRepository calRepository = new CalRepositoryImpl();
        Validator validator = new Validator();
        Calculator calculator = new Calculator(console, calculate, calRepository, validator);


        calculator.run();
    }
}
