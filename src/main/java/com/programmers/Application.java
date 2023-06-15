package com.programmers;

import com.programmers.calculator.controller.CalculatorController;
import com.programmers.calculator.domain.Calculator;
import com.programmers.calculator.domain.component.Converter;
import com.programmers.calculator.domain.component.Parser;
import com.programmers.calculator.domain.component.PostfixConverter;
import com.programmers.calculator.domain.component.RegexParser;
import com.programmers.calculator.repository.HistoryMapRepository;
import com.programmers.calculator.repository.HistoryRepository;
import com.programmers.calculator.view.Console;
import com.programmers.calculator.view.Input;
import com.programmers.calculator.view.InputReader;
import com.programmers.calculator.view.Output;
import com.programmers.calculator.view.OutputWriter;

public class Application {
    public static void main(String[] args) {

        // view
        Input input = new InputReader();
        Output output = new OutputWriter();
        Console console = new Console(input, output);

        // domain
        Parser parser = new RegexParser();
        Converter converter = new PostfixConverter();
        Calculator calculator = new Calculator(parser, converter);

        // repository
        HistoryRepository repository = new HistoryMapRepository();

        // controller
        CalculatorController calculatorController = new CalculatorController(console, calculator, repository);
        calculatorController.run();
    }
}
