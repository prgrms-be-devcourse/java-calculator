package com.devcourse.calc.model;

import java.util.Objects;

public class Operand implements Token {

    private final int number;

    public Operand(int number) {
        this.number = number;
    }

    @Override
    public boolean isDigit() {
        return true;
    }

    @Override
    public int getProcessedNumber(int... numbers) {
        return this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operand operand = (Operand) o;
        return number == operand.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
