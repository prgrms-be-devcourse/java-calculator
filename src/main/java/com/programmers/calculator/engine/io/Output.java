package com.programmers.calculator.engine.io;

public interface Output {
    void printResult(int result);
    void inputError();
    void printEmpty();
    void printExpressionAndResult(String expression, int result);
}
