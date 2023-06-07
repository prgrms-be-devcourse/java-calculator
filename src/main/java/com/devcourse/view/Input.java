package com.devcourse.view;

import com.devcourse.valid.FormulaValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private Input() {
    }

    public static int selectMenu() {
        try {
            return Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getFormula() {
        try {
            String formula = reader.readLine();
            if (FormulaValidator.valid(formula)) {
                return formula;
            }
            throw new RuntimeException();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
