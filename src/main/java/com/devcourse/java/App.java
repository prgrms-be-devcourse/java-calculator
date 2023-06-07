package com.devcourse.java;

import com.devcourse.java.common.Factory;
import com.devcourse.java.common.Storage;
import com.devcourse.java.domain.Result.Result;
import com.devcourse.java.domain.Result.ResultStorage;
import com.devcourse.java.domain.Runner.CalculatorRunner;
import com.devcourse.java.domain.console.Console;
import com.devcourse.java.domain.console.Input;
import com.devcourse.java.domain.console.Output;
import com.devcourse.java.domain.console.InputImpl;
import com.devcourse.java.domain.console.OutputImpl;
import com.devcourse.java.domain.menu.Menu;
import com.devcourse.java.domain.menu.MenuFactory;
import com.devcourse.java.domain.menu.Menus;
import com.devcourse.java.domain.menu.Calculate;
import com.devcourse.java.domain.menu.Query;

public class App {
    public static void main(String[] args) {
        Storage<Result> resultStorage = new ResultStorage();
        Input reader = new InputImpl();
        Output writer = new OutputImpl();
        Console console = new Console(reader, writer);
        Factory<Menu, Menus> menuFactory = new MenuFactory(Query.getInstance(resultStorage), Calculate.getInstance(resultStorage));

        CalculatorRunner calculatorRunner = new CalculatorRunner(menuFactory, console);
        calculatorRunner.run();
    }
}
