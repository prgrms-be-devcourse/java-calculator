package org.programmers;

import org.programmers.Io.Console;
import org.programmers.calculator.Calculator;
import org.programmers.calculator.ExpressionEvaluator;
import org.programmers.repository.CalRepository;
import org.programmers.repository.CalRepositoryImpl;

public class Application {
    public static void main(String[] args) {
        Console console = new Console();
        ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();
        CalRepository calRepository = new CalRepositoryImpl();

        Calculator calculator = new Calculator(console, expressionEvaluator, calRepository);
        calculator.run();
    }
}
