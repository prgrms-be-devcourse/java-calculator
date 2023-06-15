package org.programmers;

import org.programmers.calculator.Calculator;
import org.programmers.calculator.PostfixCalculator;
import org.programmers.controller.AppController;
import org.programmers.controller.CalculatorManagement;
import org.programmers.converter.Converter;
import org.programmers.converter.PostfixConverter;
import org.programmers.expression.ExpressionValidator;
import org.programmers.io.*;
import org.programmers.repository.ExpressionRepository;
import org.programmers.repository.Repository;

public class App {
    public static void main(String[] args) {

        // console
        Input input = new ConsoleInput();
        Output output = new ConsoleOutput();
        Console console = new Console(input, output);

        // repository
        Repository repository = new ExpressionRepository();

        // calculator
        ExpressionValidator validator = new ExpressionValidator();
        Calculator calculator = new PostfixCalculator(validator);
        Converter converter = new PostfixConverter(validator);

        // controller
        CalculatorManagement calculatorManagement = new CalculatorManagement(calculator, converter);
        AppController appController = new AppController(console, repository, calculatorManagement);
        appController.run();
    }
}