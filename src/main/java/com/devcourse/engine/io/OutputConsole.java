package com.devcourse.engine.io;

import java.util.List;

public class OutputConsole {

    public void printNewLine() {
        System.out.println();
    }

    public void endGame() {
        System.out.println("게임을 종료합니다.");
        printNewLine();
    }

    public void printError(String errorMessage) {
        System.out.println(errorMessage);
        printNewLine();
    }

    public void showResult(double result) {
        System.out.println(result);
        printNewLine();
    }

    public void showHistory(int index, List<String> history) {
        System.out.println("#" + index + ". " +
                String.join(" ", history.subList(0, history.size()-1)) +
                " = " + history.get(history.size()-1)
        );
    }
}
