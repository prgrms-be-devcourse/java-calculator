package com.programmers;

import com.programmers.core.CalculatorManager;
import com.programmers.core.Converter;
import com.programmers.core.PostfixConverter;
import com.programmers.model.AbstractCalculator;
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
        AbstractCalculator calculator = new Calculator(converter);

        CalculatorManager calculatorManager = new CalculatorManager(repository, console, calculator);
        calculatorManager.run();
    }
}