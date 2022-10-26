package org.example.io;

import org.example.repository.Repository;

public interface Output {
    void printMenu(String menu);
    void printCalculatedResult(long result);
    void printSavedResults(Repository repository);


}
