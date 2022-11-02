package com.calculator;

import com.calculator.common.Calculator;
import com.calculator.common.ValidatorHandler;
import com.calculator.io.Console;
import com.calculator.repository.MapRepository;

public class Application {

    public static void main(String[] args) {
        MapRepository mapRepository = new MapRepository();
        ValidatorHandler validatorHandler = new ValidatorHandler();
        Console console = new Console(validatorHandler);

        new Calculator(console, console, mapRepository).run();
    }
}