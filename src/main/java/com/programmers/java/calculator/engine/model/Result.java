package com.programmers.java.calculator.engine.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Result {
    private String oper;
    private double answer;
    @Override
    public String toString() {
        return oper + " = " + answer;
    }
}
