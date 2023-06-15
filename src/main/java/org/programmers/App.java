package org.programmers;

import org.programmers.calculator.Calculator;
import org.programmers.calculator.PostfixCalculator;
import org.programmers.controller.AppController;
import org.programmers.controller.CalculatorManagement;
import org.programmers.converter.Converter;
import org.programmers.converter.PostfixConverter;
import org.programmers.io.*;
import org.programmers.repository.ExpressionRepository;
import org.programmers.repository.Repository;

public class App {
    public static void main(String[] args) {

        Input input = new ConsoleInput();
        Output output = new ConsoleOutput();

        Console console = new Console(input, output);

        Repository repository = new ExpressionRepository();

        Calculator calculator = new PostfixCalculator();
        Converter converter = new PostfixConverter();

        CalculatorManagement calculatorManagement = new CalculatorManagement(calculator, converter);

        AppController appController = new AppController(console, repository, calculatorManagement);
        appController.run();
    }
}