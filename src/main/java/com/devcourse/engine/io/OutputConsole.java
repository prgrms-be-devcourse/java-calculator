package com.devcourse.engine.io;

public class OutputConsole implements Output {
    @Override
    public void endGame() {
        System.out.println("게임을 종료합니다.\n");
    }

    @Override
    public void printError(String errorMessage) {
        System.out.println(errorMessage + "\n");
    }

    @Override
    public void showResult(double result) {
        System.out.println(result + "\n");
    }

    @Override
    public void showHistory(String history) {
        System.out.println(history);
    }
}
