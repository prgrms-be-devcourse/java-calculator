package com.devcourse;

import com.devcourse.engine.io.Output;

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
}
