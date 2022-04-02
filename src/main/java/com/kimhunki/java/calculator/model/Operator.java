package com.kimhunki.java.calculator.model;

import com.kimhunki.java.calculator.enums.Operations;

public class Operator {
    public double operate(double num1, double num2, Operations oper) {
        if (oper.equals(Operations.PLUS)) return plus(num1, num2);
        else if (oper.equals(Operations.MINUS)) return minus(num1, num2);
        else if (oper.equals(Operations.MUL)) return mul(num1, num2);
        else if (oper.equals(Operations.DIV)) return div(num1, num2);
        else return 0;

    }

    private double plus(double num1, double num2) {
        return num1 + num2;
    }

    private double minus(double num1, double num2) {
        return num1 - num2;
    }

    private double div(double num1, double num2) {
        if (num2 == 0) return -1; // 음수는 없기 때문에 (괄호가 있으면 수정 요망)
        return num1 / num2;
    }

    private double mul(double num1, double num2) {
        return num1 * num2;
    }

}
