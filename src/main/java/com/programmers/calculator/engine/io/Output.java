package com.programmers.calculator.engine.io;

public interface Output {
    void inputError(Exception e);

    void formulaList();

    void endNotification();
}
