package com.programmers.calculator.controller.io;

public class ConsoleRequest {

    private final String expression;

    public ConsoleRequest(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return this.expression;
    }

}
