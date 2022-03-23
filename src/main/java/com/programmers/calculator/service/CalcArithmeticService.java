package com.programmers.calculator.service;

public class CalcArithmeticService {
    public Double calcPlus(int a, int b) {
        return (double) a + b;
    }

    public Double calcMulti(int a, int b) {
        return (double) a * b;
    }

    public Double calcDivi(int a, int b) {
        if (a == 0 || b == 0) {
            System.out.println("0으로 나눌 수 없습니다.");
            return (double) 0;
        }
        return (double) a / b;
    }

    public Double calcMinus(int a, int b) {
        return (double) a - b;
    }
}
