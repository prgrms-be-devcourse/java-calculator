package com.devcourse.calc.model;

public class Number implements Token{

    private final int number;

    public Number(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return String.valueOf(number).concat("\n");
    }

    public int getNumber() {
        return number;
    }
}
