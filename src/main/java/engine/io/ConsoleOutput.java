package engine.io;

import engine.history.History;

public class ConsoleOutput implements Output{
    @Override
    public void printError(String message) {
        System.out.println(message);
    }

    @Override
    public void showHistory(History history) {
        System.out.println(history.getAll());
    }
}
