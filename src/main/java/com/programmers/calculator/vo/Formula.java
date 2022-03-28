package com.programmers.calculator.vo;

import java.util.Arrays;

public class Formula {
    private final String[] originFormula;
    private final String result;

    public Formula(String[] originFormula, String result) {
        this.originFormula = originFormula;
        this.result = result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Arrays.stream(originFormula).forEach(token->{
            builder.append(token).append(' ');
        });
        return builder + "= " + result;
    }
}
