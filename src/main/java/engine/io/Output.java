package engine.io;

import engine.history.Histories;

public interface Output {
    void printError(String message);

    void showHistory(Histories histories);

    void printAnswer(String answer);
}
