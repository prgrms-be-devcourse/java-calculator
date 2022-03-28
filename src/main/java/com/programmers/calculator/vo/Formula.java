package com.programmers.calculator.vo;

import java.util.Arrays;
import java.util.Objects;

public class Formula {
    private final String[] originFormula;
    private final String result;

    public Formula(String[] originFormula, String result) {
        this.originFormula = originFormula;
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Formula formula = (Formula) o;
        return Arrays.equals(originFormula, formula.originFormula) && result.equals(formula.result);
    }

    @Override
    public int hashCode() {
        int hash = Objects.hash(result);
        hash = 31 * hash + Arrays.hashCode(originFormula);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Arrays.stream(originFormula).forEach(token -> {
            builder.append(token).append(' ');
        });
        return builder + "= " + result;
    }
}
