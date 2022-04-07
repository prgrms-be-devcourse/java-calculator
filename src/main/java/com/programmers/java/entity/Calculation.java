package com.programmers.java.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class Calculation {

    private String formula;
    private int result;

    @Override
    public String toString() {
        return formula + " = " + result;
    }
}
