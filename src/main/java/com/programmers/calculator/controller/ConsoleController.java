package com.programmers.calculator.controller;

import com.programmers.calculator.controller.io.Request;
import com.programmers.calculator.controller.io.Response;
import com.programmers.calculator.core.Expression;
import com.programmers.calculator.service.CalculatorService;

public class ConsoleController{

    private final CalculatorService calculatorService;

    public ConsoleController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public Response inquiry() {
        return calculatorService.findAllOrderById();
    }

    public Response calculate(Request request) {
        return calculatorService.process(new Expression(request.getInput()));
    }

}
