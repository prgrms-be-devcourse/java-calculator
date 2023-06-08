package com.devcourse.java;

import com.devcourse.java.common.Factory;
import com.devcourse.java.domain.storage.Storage;
import com.devcourse.java.domain.storage.CalculateResult;
import com.devcourse.java.domain.storage.MemoryStorage;
import com.devcourse.java.domain.parser.ExpressionParser;
import com.devcourse.java.domain.parser.PrefixParser;
import com.devcourse.java.domain.runner.CalculatorRunner;
import com.devcourse.java.domain.calculator.Calculator;
import com.devcourse.java.domain.console.Console;
import com.devcourse.java.domain.console.Input;
import com.devcourse.java.domain.console.Reader;
import com.devcourse.java.domain.console.Output;
import com.devcourse.java.domain.console.Writer;
import com.devcourse.java.domain.menu.Calculate;
import com.devcourse.java.domain.menu.Menu;
import com.devcourse.java.domain.menu.MenuFactory;
import com.devcourse.java.domain.menu.Menus;
import com.devcourse.java.domain.menu.Query;
import com.devcourse.java.domain.validator.Validator;

public class App {
    public static void main(String[] args) {
        Storage<CalculateResult> resultStorage = new MemoryStorage();
        Input reader = new Reader();
        Output writer = new Writer();
        Console console = new Console(reader, writer);
        Validator validator = new Validator();
        Query query = new Query(resultStorage, validator);
        ExpressionParser prefixParser = new PrefixParser();
        Calculator calculator = new Calculator(prefixParser);
        Calculate calculate = new Calculate(calculator, resultStorage, validator);
        Factory<Menu, Menus> menuFactory = new MenuFactory(query, calculate);

        CalculatorRunner calculatorRunner = new CalculatorRunner(menuFactory, console);
        calculatorRunner.run();
    }
}
