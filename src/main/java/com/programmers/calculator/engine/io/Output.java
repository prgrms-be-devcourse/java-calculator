package com.programmers.calculator.engine.io;

public interface Output {
    public void printResult(int result);
    public void inputError();
    public void printEmpty();
    public void printExpressionAndResult(String expression, int result);
}
