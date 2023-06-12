package org.programmers;

import org.programmers.Io.Console;
import org.programmers.calculator.Calculator;
import org.programmers.calculator.ExpressionEvaluator;
import org.programmers.validator.Validator;

public class Application {
    public static void main(String[] args) {
        Console console = new Console();
        ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();
        Calculator calculator = new Calculator(console, expressionEvaluator);
        calculator.run();
    }
}
