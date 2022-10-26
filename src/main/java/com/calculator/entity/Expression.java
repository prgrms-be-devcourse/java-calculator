package com.calculator.entity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Expression {
    private String operators;     // 후위 표기법
    private int result;
}
