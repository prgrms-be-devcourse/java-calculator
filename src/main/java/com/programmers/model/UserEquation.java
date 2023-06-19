package com.programmers.model;

import com.programmers.validator.InputValidator;

public class UserEquation {
    private String equation;

    public UserEquation(String equation) {
        InputValidator.checkEquation(equation);
        this.equation = equation;
    }

    public String getEquation() {
        return equation;
    }
}
