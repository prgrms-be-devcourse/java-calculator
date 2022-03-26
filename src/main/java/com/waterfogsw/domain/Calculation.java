package com.waterfogsw.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Calculation {
    private Long id;
    private String expr;
    private String result;

    @Override
    public String toString() {
        return expr + " = " + result;
    }
}
