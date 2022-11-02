package com.calculator;

import com.calculator.controller.CalculateController;
import com.calculator.common.ValidatorHandler;
import com.calculator.io.Console;
import com.calculator.repository.MapRepository;
import com.calculator.service.CalculateService;
import com.calculator.common.Calculator;

public class Application {

    public static void main(String[] args) {
        MapRepository mapRepository = new MapRepository();
        ValidatorHandler validatorHandler = new ValidatorHandler();
        Console console = new Console(validatorHandler);
        Calculator calculator = new Calculator(mapRepository);
        CalculateService calculateService = new CalculateService(mapRepository, calculator);

        new CalculateController(console, console, calculateService).run();
    }
}