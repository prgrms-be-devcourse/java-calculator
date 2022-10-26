package com.calculator.entity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Expression {
    private String infix;   // 중위 표기법
    private double result;

    @Override
    public String toString() {
        return infix + " = " + result;
    }
}
