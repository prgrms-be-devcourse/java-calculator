package com.programmers;

import com.programmers.core.CalculatorManager;
import com.programmers.core.calculator.Calculator;
import com.programmers.core.calculator.PostfixCalculator;
import com.programmers.core.converter.Converter;
import com.programmers.core.converter.PostfixConverter;
import com.programmers.core.manager.CalculationRequestManager;
import com.programmers.core.manager.CalculatorProcessor;
import com.programmers.core.manager.MenuManager;
import com.programmers.core.manager.ResultPrinter;
import com.programmers.repository.CalculationRepository;
import com.programmers.repository.InMemoryCalculationRepository;
import com.programmers.view.Console;
import com.programmers.view.Input;
import com.programmers.view.Output;
import com.programmers.view.Reader;
import com.programmers.view.Writer;

public class Main {
    public static void main(String[] args) {
        CalculationRepository repository = new InMemoryCalculationRepository();
        Input reader = new Reader();
        Output writer = new Writer();
        Console console = new Console(reader, writer);
        Converter converter = new PostfixConverter();
        Calculator calculator = new PostfixCalculator(converter);

        MenuManager menuManager = new MenuManager(console);
        CalculationRequestManager requestManager = new CalculationRequestManager(console);
        CalculatorProcessor calculatorProcessor = new CalculatorProcessor(calculator, repository, console);
        ResultPrinter resultPrinter = new ResultPrinter(console);
        CalculatorManager calculatorManager = new CalculatorManager(menuManager, requestManager, calculatorProcessor, resultPrinter, repository);
        calculatorManager.run();
    }
}