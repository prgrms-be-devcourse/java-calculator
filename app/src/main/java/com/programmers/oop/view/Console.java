package com.programmers.oop.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console implements Input, Output {

    private static final BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in));


    @Override
    public String readInput() throws IOException {
        return reader.readLine();
    }

    @Override
    public void showMessage(String message) {

    }
}
