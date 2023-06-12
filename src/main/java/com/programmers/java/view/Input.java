package com.programmers.java.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
    public Button enterMenu() throws IOException {

        Button button = null;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Button selected = Button.findByValue(input);

        return selected;
    }

    public String enterExpression() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();
        return expression;
    }
}