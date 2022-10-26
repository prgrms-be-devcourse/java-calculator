package com.programmers.calculator.controller.io;

public class ConsoleRequest implements Request {

    private final String input;

    public ConsoleRequest(String input) {
        this.input = input;
    }

    @Override
    public String getInput() {
        return this.input;
    }

}
