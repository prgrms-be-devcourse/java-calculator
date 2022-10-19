package calculator;

import calculator.calculate.Calculation;
import calculator.calculate.CalculationImpl;
import calculator.repository.Repository;
import calculator.repository.RepositoryImpl;


import java.io.IOException;

/**
 * entry point
 */
public class App {
    public static void main(String[] args) throws IOException {
        Console console = new Console();
        Repository repository = new RepositoryImpl();
        Calculation calculation = new CalculationImpl();
        Calculator calculator = new Calculator(console,console,repository,calculation);
        calculator.run();
    }
}
