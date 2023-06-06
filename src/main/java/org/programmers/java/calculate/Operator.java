package org.programmers.java.calculate;

import java.util.function.BiFunction;

public class Operator {

    static public int plus(int a, int b){
        return a + b;
    }
    static public int minus(int a, int b){
        return a - b;
    }
    static public int multiply(int a, int b){
        return a * b;
    }
    static public int divide(int a, int b){
        if(b == 0) throw new ArithmeticException("0으로 나눌 수 없습니다.");
        return a / b;
    }
}
