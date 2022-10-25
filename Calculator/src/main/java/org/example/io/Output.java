package org.example.io;

import org.example.repository.Repository;

public interface Output {
    void printMenu(String menu);
    void printCalculatedResult(int result);
    void printSavedResults(Repository repository);


}
