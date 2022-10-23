package engine.io;

import engine.history.History;

public interface Output {
    void printError(String message);

    void showHistory(History history);
}
