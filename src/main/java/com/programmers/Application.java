package com.programmers;

import com.programmers.calculator.controller.CalculatorController;
import com.programmers.calculator.domain.component.Converter;
import com.programmers.calculator.domain.component.Evaluator;
import com.programmers.calculator.domain.component.FourArithmeticParser;
import com.programmers.calculator.domain.component.Parser;
import com.programmers.calculator.domain.component.PostfixConverter;
import com.programmers.calculator.domain.component.PostfixEvaluator;
import com.programmers.calculator.domain.core.Calculator;
import com.programmers.calculator.domain.core.FourArithmeticCalculator;
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
        Parser parser = new FourArithmeticParser();
        Converter converter = new PostfixConverter();
        Evaluator evaluator = new PostfixEvaluator();
        Calculator calculator = new FourArithmeticCalculator(parser, converter, evaluator);

        // repository
        HistoryRepository repository = new HistoryMapRepository();

        // controller
        CalculatorController calculatorController = new CalculatorController(console, calculator, repository);
        calculatorController.run();

    }
}
