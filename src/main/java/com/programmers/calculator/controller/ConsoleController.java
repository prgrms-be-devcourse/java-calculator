package com.programmers.calculator.controller;

import com.programmers.calculator.controller.io.ConsoleRequest;
import com.programmers.calculator.controller.io.ConsoleResponse;
import com.programmers.calculator.core.Expression;
import com.programmers.calculator.service.CalculatorService;

public class ConsoleController{

    private final CalculatorService calculatorService;

    public ConsoleController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public ConsoleResponse inquiry() {
        return calculatorService.findAllOrderById();
    }

    public ConsoleResponse calculate(ConsoleRequest request) {
        return calculatorService.process(new Expression(request.getExpression()));
    }

}
