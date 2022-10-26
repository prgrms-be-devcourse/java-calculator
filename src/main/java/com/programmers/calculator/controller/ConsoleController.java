package com.programmers.calculator.controller;

import com.programmers.calculator.controller.io.Request;
import com.programmers.calculator.controller.io.Response;
import com.programmers.calculator.core.Expression;
import com.programmers.calculator.service.CalculatorService;

public class ConsoleController implements Controller {

    private final CalculatorService calculatorService;

    public ConsoleController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @Override
    public Response inquiry() {
        return calculatorService.findAllOrderById();
    }

    @Override
    public Response calculate(Request request) {
        return calculatorService.process(new Expression(request.getInput()));
    }

}
