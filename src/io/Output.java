package src.io;

import src.log.Log;

import java.util.List;

public interface Output {
    void printPrompt();
    void printError(String message);
    void printLog(List<Log> logs);
    void printAnswer(String answer);
}
