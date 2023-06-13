package com.programmers.service;

import com.programmers.domain.SelectionValidator;
import com.programmers.io.Console;

public class CalculatorService {

    private final Console console;
    private final SelectionValidator selectionValidator = new SelectionValidator();

    public CalculatorService(Console console) {
        this.console = console;
    }

    public int getValidatedMenuSelection() {
        String selection = console.getSelection();

        try {
            selectionValidator.validate(selection);
            return Integer.parseInt(selection);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getValidatedMenuSelection();
        }
    }
}
