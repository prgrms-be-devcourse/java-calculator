package com.programmers.calculator.io;

public interface Output {
    void displayMenu();

    <T> void displayResult(T result);
}
