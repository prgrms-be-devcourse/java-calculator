package com.devcourse.calc.model;

public class Operand implements Token {

    private final int number;

    public Operand(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    public int getNumber() {
        return number;
    }
}
