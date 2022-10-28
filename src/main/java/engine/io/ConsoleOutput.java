package engine.io;

import engine.history.Histories;

public class ConsoleOutput implements Output {
    @Override
    public void printError(String message) {
        System.out.println(message);
    }

    @Override
    public void showHistory(Histories histories) {
        System.out.println(histories.convertToString());
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}
