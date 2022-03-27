package com.programmers.calculator.service;

public class ArithmeticService {
    public Double calcPlus(double a, double b) {
        return a + b;
    }

    public Double calcMulti(double a, double b) {
        return a * b;
    }

    public Double calcDivi(double a, double b) {
        if (a == 0 || b == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return a / b;
    }

    public Double calcMinus(double a, double b) {
        return a - b;
    }
}
