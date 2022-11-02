package com.calculator.io;

import com.calculator.common.ValidatorHandler;

import java.io.IOException;

public class Console implements Input, Output{

    private final ValidatorHandler validatorHandler;

    public Console(ValidatorHandler validatorHandler) {
        this.validatorHandler = validatorHandler;
    }

    @Override
    public String command() {
        String input = "";
        try {
            input = br.readLine();
            validatorHandler.inputError(input);
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }

        return input;
    }

    @Override
    public void display(String output) {
        System.out.println(output);
    }
}
