package calculator;

import calculator.calculate.Calculator;
import calculator.calculate.CalculatorImpl;
import calculator.console.Console;
import calculator.repository.ResultRepositoryImpl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Calculator calculator = new CalculatorImpl(new Console(), ResultRepositoryImpl.getInstance());
        calculator.run();
    }
}
