package com.programmers.javaCalculator.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Expression {

    private String validExpression;
    private String result;

    @Override
    public String toString() {
        return validExpression + " = " + result;
    }

}