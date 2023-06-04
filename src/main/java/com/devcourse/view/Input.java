package com.devcourse.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static int selectMenu() {
        try {
            return Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getFormula() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
