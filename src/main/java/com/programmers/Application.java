package com.programmers;

import com.programmers.calculator.controller.CalculatorController;
import com.programmers.calculator.domain.Calculator;
import com.programmers.calculator.domain.Expression;
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
        Calculator calculator = new Calculator(new Expression());

        // repository
        HistoryRepository repository = new HistoryMapRepository();

        // controller
        CalculatorController calculatorController = new CalculatorController(console, calculator, repository);
        calculatorController.run();
    }
}
