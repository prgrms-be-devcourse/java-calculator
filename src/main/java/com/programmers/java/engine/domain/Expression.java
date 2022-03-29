package com.programmers.java.engine.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Expression {
    private String[] operators;
    private Double[] operands;
}
