package com.programmers.java.engine.domain;

import java.util.Arrays;

public class Operand {
    public Double[] operands;
    public Operand(String input, String operatorPattern){
        this.operands = Arrays.stream(input.split(operatorPattern)).map(Double::valueOf).toArray(Double[]::new);
    }
}
