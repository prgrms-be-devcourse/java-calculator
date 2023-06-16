package com.devcourse.engine.io;

import java.util.List;

public class OutputConsole {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void endGame() {
        System.out.println("게임을 종료합니다.\n");
    }

    public void printError(String errorMessage) {
        System.out.println(errorMessage + "\n");
    }

    public void showResult(double result) {
        System.out.println(result + "\n");
    }

    public void showHistory(int index, List<String> history) {
        System.out.println("#" + index + ". " +
                String.join(" ", history.subList(0, history.size()-1)) +
                " = " + history.get(history.size()-1)
        );
    }
}
