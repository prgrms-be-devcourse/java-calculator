package com.programmers.java.calculator.engine.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Result {
    String oper;
    int answer;
    @Override
    public String toString() {
        return oper + " = " + answer;
    }
}
