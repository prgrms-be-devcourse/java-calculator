package com.devcourse.engine.io;

public class OutputConsole implements Output {
    @Override
    public void endGame() {
        System.out.println("게임을 종료합니다.");
    }

    @Override
    public void printError(String errorMessage) {
        System.out.println(errorMessage);
    }

    @Override
    public void showResult(double result) {
        System.out.println(result);
    }

    @Override
    public void showHistory(String history) {
        if (history.length() == 0) {
            System.out.println("표시할 이력이 없습니다.");
        } else {
            System.out.println(history);
        }
    }
}
