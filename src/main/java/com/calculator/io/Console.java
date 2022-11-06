package com.calculator.io;

import java.io.IOException;

public class Console implements Input, Output{

    public Console() {
    }

    @Override
    public String command() {
        String input = "";
        try {
            input = br.readLine();
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
