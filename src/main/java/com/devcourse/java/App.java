package com.devcourse.java;

import com.devcourse.java.domain.calculator.Calculator;
import com.devcourse.java.domain.calculator.PrefixCalculator;
import com.devcourse.java.domain.console.Console;
import com.devcourse.java.domain.console.io.Reader;
import com.devcourse.java.domain.console.io.Writer;
import com.devcourse.java.domain.console.io.ConsoleReader;
import com.devcourse.java.domain.console.io.ConsoleWriter;
import com.devcourse.java.domain.factory.Factory;
import com.devcourse.java.domain.factory.MenuFactory;
import com.devcourse.java.domain.factory.OperatorFactory;
import com.devcourse.java.domain.menu.Calculate;
import com.devcourse.java.domain.menu.Menu;
import com.devcourse.java.domain.menu.Menus;
import com.devcourse.java.domain.menu.Query;
import com.devcourse.java.domain.operator.Operator;
import com.devcourse.java.domain.calculator.parser.PrefixParser;
import com.devcourse.java.domain.runner.CalculatorRunner;
import com.devcourse.java.domain.storage.CalculateResult;
import com.devcourse.java.domain.storage.MemoryStorage;
import com.devcourse.java.domain.storage.Storage;

public class App {
    public static void main(String[] args) {
        Storage<CalculateResult> resultStorage = new MemoryStorage();

        PrefixParser prefixParser = new PrefixParser();
        Factory<Operator, String> operatorFactory = new OperatorFactory();
        Calculator prefixCalculator = new PrefixCalculator(prefixParser, operatorFactory);

        Query query = new Query(resultStorage);
        Calculate calculate = new Calculate(prefixCalculator, resultStorage);

        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        Console console = new Console(reader, writer);
        Factory<Menu, Menus> menuFactory = new MenuFactory(query, calculate);

        CalculatorRunner calculatorRunner = new CalculatorRunner(menuFactory, console);
        calculatorRunner.run();
    }
}
