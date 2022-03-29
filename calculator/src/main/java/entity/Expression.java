package entity;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Expression {
    private String input;
    private double result;

    public Expression(String input, double result) {
        this.input = input;
        this.result = result;
    }

    @Override
    public String toString() {

        StringBuffer sb = new StringBuffer();
        sb.append(this.input).append(" = ").append(this.result);

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        return this.hashCode() == o.hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(input, result);
    }
}
