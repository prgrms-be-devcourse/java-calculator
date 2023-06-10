package com.devcourse.engine.io;

public interface Output {
    void endGame();

    void printError(String errorMessage);

    void showResult(double result);

    void showHistory(String history);
}
