package main.java.view;

import main.java.repository.Repository;

public interface Output {
    void exitProgram();
    void showHistory(Repository repository);
    void printMenu();
}
