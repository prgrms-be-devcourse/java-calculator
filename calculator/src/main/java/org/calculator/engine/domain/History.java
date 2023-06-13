package org.calculator.engine.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class History {
    private String equation;
    private double result;
}
