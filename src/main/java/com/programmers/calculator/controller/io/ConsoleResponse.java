package com.programmers.calculator.controller.io;

public class ConsoleResponse implements Response {

    private final String result;

    public ConsoleResponse(String result) {
        this.result = result;
    }

    public String result() {
        return this.result;
    }

}
