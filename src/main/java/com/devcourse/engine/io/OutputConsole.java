package com.devcourse.engine.io;

public class OutputConsole {

    public void endGame() {
        System.out.println("게임을 종료합니다.\n");
    }

    public void printError(String errorMessage) {
        System.out.println(errorMessage + "\n");
    }

    public void showResult(double result) {
        System.out.println(result + "\n");
    }

    public void showHistory(String history) {
        System.out.println(history);
    }
}
