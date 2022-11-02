package com.calculator.io;

import com.calculator.common.ValidatorHandler;

import java.io.IOException;

public class Console implements Input, Output{

    private final ValidatorHandler validatorHandler;

    public Console(ValidatorHandler validatorHandler) {
        this.validatorHandler = validatorHandler;
    }

    @Override
    public String inputType() {
        System.out.println("\n1. 조회\n2. 계산\n3. 끝");
        System.out.print("\n선택 : ");

        String input = null;
        try {
            input = br.readLine();
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
        System.out.println();
        return input;
    }

    @Override
    public String inputNum() {
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
    public void outputDisplay(String output) {
        System.out.println(output);
    }
}
