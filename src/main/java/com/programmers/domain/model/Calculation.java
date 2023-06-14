package com.programmers.domain.model;

import java.util.List;
import java.util.Objects;

public class Calculation {
    private final List<String> expression;
    private final int result;

    public Calculation(List<String> expression, int result) {
        this.expression = expression;
        this.result = result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String token : expression) {
            sb.append(token);
            sb.append(" ");
        }
        sb.append("= ");
        sb.append(result);

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (o.getClass() == String.class) {
            return toString().equals(o);
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        Calculation that = (Calculation) o;
        return result == that.result && Objects.equals(expression, that.expression);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expression, result);
    }
}
