package com.devcourse.java;

import com.devcourse.java.domain.calculator.Calculator;
import com.devcourse.java.domain.calculator.PrefixCalculator;
import com.devcourse.java.domain.calculator.parser.PrefixParser;
import com.devcourse.java.domain.console.Console;
import com.devcourse.java.domain.console.io.ConsoleReader;
import com.devcourse.java.domain.console.io.ConsoleWriter;
import com.devcourse.java.domain.console.io.Reader;
import com.devcourse.java.domain.console.io.Writer;
import com.devcourse.java.domain.operator.OperatorMapper;
import com.devcourse.java.domain.menu.Calculate;
import com.devcourse.java.domain.menu.MenuMapper;
import com.devcourse.java.domain.menu.Query;
import com.devcourse.java.domain.runner.CalculatorRunner;
import com.devcourse.java.domain.storage.CalculateResult;
import com.devcourse.java.domain.storage.MemoryStorage;
import com.devcourse.java.domain.storage.Storage;

public class App {
    public static void main(String[] args) {
        Storage<CalculateResult> resultStorage = new MemoryStorage();

        PrefixParser prefixParser = new PrefixParser();
        OperatorMapper operatorMapper = new OperatorMapper();
        Calculator prefixCalculator = new PrefixCalculator(prefixParser, operatorMapper);

        Query query = new Query(resultStorage);
        Calculate calculate = new Calculate(prefixCalculator, resultStorage);

        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        Console console = new Console(reader, writer);
        MenuMapper menuMapper = new MenuMapper(query, calculate);

        CalculatorRunner calculatorRunner = new CalculatorRunner(menuMapper, console);
        calculatorRunner.run();
    }
}
